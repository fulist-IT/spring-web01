"use strict";

/*
For Fetch details refer to
https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch
https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API
*/

class HttpErrorImpl extends Error {
  constructor(message, status, text, url, ...data) {
    super(message);
    this.message = message;
    this.status = status;
    this.text = text;
    this.data = data;
    this.url = url;
  }
}

/**
 * Semplice funzione per il fetch di una risorsa
 * @param {*} url la url da utilizzare
 * @param {*} fetchObjects l'oggetto della request, in caso di fetch GET senza parametri può essere omesso o null
 * @param {*} targetFunction la funzione da invocare se l'esito della fetch è positivo
 * @param {*} errorFunction la funzione di gestione errori in caso di esito negativo
 */
function doFetchJson(url, fetchObjects, targetFunction, errorFunction = (x) => console.log(x)) {
  fetch(url, fetchObjects)
    .then((response) => {
      if (!response.ok) {
        console.log(`status:${response.status} text:${response.statusText}`);
        //throw new HttpErrorImpl("Network response error", response.status, response.statusText, url, response.json());
      }
      return response.json();
    })
    .then((data) => {
      if (data.error) {
        errorFunction(data);
      } else {
        targetFunction(data);
      }
    })
    .catch((error) => {
      errorFunction(error);
    });
}

async function doFetchJsonAsync(
  url = "",
  fetchObjects = {},
  targetFunction = (x) => console.log(x),
  targetErrorFunction = (x) => console.error(` TEF: ${x}`),
  errorHandler = (x) => console.error(`EH: ${x}`)
) {
  let errorFlag = false;
  let eStatus;
  let eStatusText;
  try {
    const response = await fetch(url, fetchObjects);
    eStatus = response.status;
    eStatusText = response.statusText;
    if (!response.ok) {
      errorFlag = true;
    }

    const heds = response.headers;
    // heds.forEach((h,k,o) => console.log(h,k,o))

    let retrieve = true;
    if (heds.has("content-length")) {
      const contentLength = parseInt(heds.get("content-length"));
      // console.log(`content-length is present: ${contentLength}`);
      retrieve = !contentLength <= 0;
    }

    console.log(`response url=${response.url} HTTP status:${eStatus} [${eStatusText}]`);

    if (retrieve) {
      const data = await response.json();
      if (errorFlag) {
        try {
          targetErrorFunction(data);
          return;
        } catch (error) {
          console.trace(error);
        }
      } else {
        try {
          targetFunction(data);
          return;
        } catch (error) {
          console.trace(error);
        }
      }
    } // end if(retrieve)
    try {
      targetErrorFunction(null);
    } catch (error) {
      console.trace(error);
    }
  } catch (error) {
    //console.log(error);
    errorHandler(`response.status=${eStatus}[${eStatusText}] ${error}`);
  } finally {
    console.log("End of fetch...");
  }
}

async function _doFetchJsonAsync(url, fetchObjects, errorFunction = (x) => console.log(x)) {
  const jsonData = await fetch(url, fetchObjects)
    .then((response) => {
      if (!response.ok) {
        console.log(response.status); // not 200
        console.log(response.statusText); // not OK
        throw new Error("Network response was not ok RC=" + response.status + " " + response.statusText);
      }
      return response.json();
    })
    .catch((error) => {
      // console.log("Error:", error);
      errorFunction(error);
    });
  return jsonData;
}

/*
Headers and body example
*/
const selectedMethod = "GET"; // *GET, POST, PUT, DELETE, etc.
const selectedMode = "cors"; // no-cors, *cors, same-origin
const selectedCache = "no-cache"; // *default, no-cache, reload, force-cache, only-if-cached
const selectedCredentials = "same-origin"; // include, *same-origin, omit
const selectedHeaders = {
  "Content-Type": "application/json",
  // 'Content-Type': 'application/x-www-form-urlencoded',
};
const selectedRedirect = "follow"; // manual, *follow, error
const selectedReferrerPolicy = "no-referrer"; // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
const selectedBody = (data) => JSON.stringify(data); // body data type must match "Content-Type" header

const selectedFetchObject = {
  method: selectedMethod,
  mode: selectedMode,
  cache: selectedCache,
  credentials: selectedCredentials,
  headers: selectedHeaders,
  redirect: selectedRedirect,
  referrerPolicy: selectedReferrerPolicy,
  body: selectedBody,
};

function buildDefaultFetchParams(method, payload) {
  return {
    method: method,
    mode: "cors",
    cache: "no-cache",
    credentials: "same-origin",
    headers: {
      "Content-Type": "application/json",
    },
    redirect: "follow",
    referrerPolicy: "no-referrer",
    body: JSON.stringify(payload),
  };
}
