"use strict";

/**
Classi relative alle figure geometriche
 */

class FiguraGeometrica {
  constructor() {
    if (this.constructor === FiguraGeometrica) {
      throw new Error("FYI: Instance of Abstract class cannot be instantiated");
    }
  }

  area() {
    throw new Error('metodo area() astratto, implementarlo!');
  }
  perimetro() {
    throw new Error('metodo perimetro() astratto, implementarlo!');
  }
}

class Rettangolo extends FiguraGeometrica {
  constructor(base, altezza) {
    super();
    this.base = base;
    this.altezza = altezza;
  }

  area() {
    return this.base * this.altezza;
  }
  perimetro() {
    return 2 * (this.base + this.altezza);
  }

  toString() {
    return `Rettangolo: base=${this.base} altezza=${this.altezza} area=${this.area()} perimetro=${this.perimetro()}`;
  }
}

class Quadrato extends Rettangolo {
  constructor(lato) {
    super(lato, lato);
    this.lato = lato;
  }

  toString() {
    return `Quadrato: lato=${this.lato} area=${this.area()} perimetro=${this.perimetro()}`;
  }
}

class Ellisse extends FiguraGeometrica {
  constructor(semiasseMinore, semiasseMaggiore) {
    super();
    this.semiasseMinore = semiasseMinore;
    this.semiasseMaggiore = semiasseMaggiore;
  }

  area() {
    return Math.PI * this.semiasseMinore * this.semiasseMaggiore;
  }

  perimetro() {
    return 2 * Math.PI * Math.sqrt((Math.pow(this.semiasseMinore, 2) + Math.pow(this.semiasseMaggiore, 2)) / 2);
  }

  toString() {
    return `Ellisse: semiasseMinore=${this.semiasseMinore} semiasseMaggiore=${
      this.semiasseMaggiore
    } area=${this.area()} perimetro=${this.perimetro()}`;
  }
}

class Cerchio extends Ellisse {
  constructor(raggio) {
    super(raggio, raggio);
    this.raggio = raggio;
  }

  circonferenza() {
    return perimetro();
  }

  toString() {
    return `Cerchio: raggio=${this.raggio} area=${this.area()} perimetro=${this.perimetro()}`;
  }
}

class Triangolo extends FiguraGeometrica {
  constructor(latoA, latoB, latoC) {
    super();
    if (this.canTriangolo(latoA, latoB, latoC)) {
      this.latoA = latoA;
      this.latoB = latoB;
      this.latoC = latoC;
    } else {
      throw new Error("non è stato possibile generare un triangolo genero una figura geometrica generica");
    }
  }

  canTriangolo(latoA, latoB, latoC) {
    if (latoA + latoB - latoC < 0 || latoB + latoC - latoA < 0 || latoC + latoA - latoB < 0) {
      return false;
    }
    return true;
  }

  perimetro() {
    return this.latoA + this.latoB + this.latoC;
  }

  semiPerimetro() {
    return this.perimetro() / 2;
  }

  area() {
    // formula di Erone
    // https://www.youmath.it/formulari/formulari-di-geometria-piana/406-tutte-le-formule-sul-triangolo-qualsiasi.html
    const p = this.semiPerimetro();
    return Math.sqrt(p * (p - this.latoA) * (p - this.latoB) * (p - this.latoC));
  }

  toString() {
    return `Triangolo: latoA=${this.latoA} latoB=${this.latoB} latoC=${
      this.latoC
    } area=${this.area()} perimetro=${this.perimetro()}`;
  }
}

class FiguraIrregolare extends FiguraGeometrica {
  constructor(area, perimetro) {
    super();
    this._area = area;
    this._perimetro = perimetro;
  }

  area() {
    return this._area;
  }

  perimetro() {
    return this._perimetro;
  }

  toString() {
    return `FiguraIrregolare: area=${this.area()} perimetro=${this.perimetro()}`;
  }
}

/**
 *
 * @see https://www.youmath.it/formulari/formulari-di-geometria-piana/419-tutte-le-formule-sui-poligoni-regolari.html
 */
class PoligonoRegolare extends FiguraGeometrica {
  // di cui mancano i dati
  constructor(numeroLati, lato, costanteArea) {
    super();
    this.numeroLati = numeroLati;
    this.lato = lato;
    this.costanteArea = costanteArea;
  }

  perimetro() {
    return this.lato * this.numeroLati;
  }

  area() {
    return this.lato * this.lato * this.costanteArea;
  }

  toString() {
    return `PoligonoRegolare: numeroLati=${this.numeroLati} lato=${this.lato} costanteArea=${
      this.costanteArea
    } area=${this.area()} perimetro=${this.perimetro()}`;
  }
}

/*** test ***/
const TEST_ENABLE = false;

if (TEST_ENABLE) {
  let q = new Quadrato(10);
  let r = new Rettangolo(10, 20);
  let e = new Ellisse(10, 20);
  let c = new Cerchio(10);
  let t = new Triangolo(10, 10, 10);
  let f = new FiguraIrregolare(100, 40);
  let esagono = new PoligonoRegolare(6, 10, 2.598);
  console.log(q.toString());
  console.log(r.toString());
  console.log(e.toString());
  console.log(c.toString());
  console.log(t.toString());
  console.log(f.toString());
  console.log(esagono.toString());
}
