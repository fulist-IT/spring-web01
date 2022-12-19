"use strict";

/**
 * Funzione per creare elementi DOM e settarne gli attributi
 * @param {*} type il tipo di elemento da creare
 * @param {*} attributes un js object contenente le coppie chiave/valore degli attributi da settare
 * @returns l'elemento creato
 */
function createElement(type, attributes={}) {
    const element = document.createElement(type);
    const keys = Object.keys(attributes);
    for(const k of keys) {
        element.setAttribute(k, attributes[k]);
    }
    return element
}

/**
 * Crea un DOM textNode
 * @param {*} text il test da wrappare in textNode
 * @returns il textNode creato
 */
function createTextNode(text) {
    const textNode = document.createTextNode(text);
    return textNode
}

/**
 * Crea un elemento DOM e lo appende ad un container
 * @param {*} container il contenitore da utilizzare
 * @param {*} type il tipo di elemento da creare
 * @param {*} attributes un js object contenente le coppie chiave/valore degli attributi da settare
 * @returns l'elemento creato
 */
function createAndAppendElement(container, type, attributes={}) {
    const element = createElement(type, attributes);
    container.appendChild(element);
    return element
}

/**
 * Crea un DOM textNode e lo aggiunge ad un container
 * @param {*} container l'elemento a cui aggiungere il testo
 * @param {*} text il test da wrappare in textNode
 * @returns il textNode creato
 */
function createAndAppendTextNode(container, text) {
    const textNode = createTextNode(text);
    container.appendChild(textNode);
    return textNode
}


/**
 * Rimuove tutti i figli di un contenitore
 * @param {*} parent il contenitore da svuotare
 */
function removeAllChildren(parent) {
    while(parent.firstChild) {
        parent.firstChild.remove();
    }
}