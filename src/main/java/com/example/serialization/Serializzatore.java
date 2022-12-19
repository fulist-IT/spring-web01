package com.example.serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public final class Serializzatore {

	/**
	 * Serializza un oggetto Serializable in una string UTF-8 Base64 encoded
	 * @param l'oggetto serializzabile
	 * @return la stringa contenente la serializzazione
	 */
	public static final String serializeToString(Serializable object) {
		String output = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			OutputStream encodedStream = Base64.getEncoder().wrap(baos);
			ObjectOutputStream oos = new ObjectOutputStream(encodedStream);
			oos.writeObject(object); // serializzazione
			oos.close();
			encodedStream.close();
			baos.close();
			output = new String(baos.toByteArray(), StandardCharsets.UTF_8);
		} catch (Exception e) {
			throw new SerializzatoreException("Errore durante la serializzazione ...", e);
		}
		return output;
	}

	/**
	 * Deserializza una stringa UTF-8 Base64 encoded in un oggetto serializzabile
	 * @param <T> il tipo di oggetto da ottenere
	 * @param base64String la stringa contenente la serializzazione di un oggetto
	 * @param clazz il tipo in cui convertire l'oggetto de-serializzato
	 * @return l'oggetto de-serializzato
	 */
	public static <T> T deSerialize(String base64String, Class<T> clazz) {
		T object = null;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(base64String.getBytes());
			InputStream encodedStream = Base64.getDecoder().wrap(bais);
			ObjectInputStream ois = new ObjectInputStream(encodedStream);
			object = (T) clazz.cast( ois.readObject() ); // deserializzazione
			ois.close();
			encodedStream.close();
			bais.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DeSerializzatoreException("Errore durante la de-serializzazione ...", e);
		}
		return object;
	}

	/**
	 * Realizza un clone (deep-copy) di un oggetto Serializable
	 * La copia profonda in Java si riferisce al processo di copia di oggetti da un albero
	 * in modo tale da non dipendere da nessuna delle sue versioni precedenti che potrebbero
	 * essere soggette a un certo grado di modifica.
	 * Questo processo di clonazione è reso molto più semplice adottando la serializzazione.
	 * Serializzando l'oggetto in un array di byte e successivamente de-serializzandolo,
	 * si ottiene una replica di detto oggetto.
	 * @param <T> il tipo dell'oggetto
	 * @param object l'oggetto Serializable da clonare
	 * @param clazz il tipo in cui convertire l'oggetto clonato
	 * @return l'oggetto clonato
	 */
	public static final <T> T cloneFrom(Serializable object, Class<T> clazz) {
		return deSerialize(serializeToString(object), clazz);

	}

	private static class SerializzatoreException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public SerializzatoreException(String message, Throwable cause) {
			super(message, cause);
		}
	}

	private static class DeSerializzatoreException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public DeSerializzatoreException(String message, Throwable cause) {
			super(message, cause);
		}
	}


}
