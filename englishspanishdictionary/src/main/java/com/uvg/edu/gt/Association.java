package com.uvg.edu.gt;

/**
 * Representa una asociación genérica entre una clave y un valor.
 * La clave es del tipo genérico K y debe ser comparable. El valor es del tipo
 * genérico V.
 *
 * @param <K> Tipo de la clave, debe ser Comparable.
 * @param <V> Tipo del valor asociado con la clave.
 */
public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;

    /**
     * Crea una nueva asociación con una clave y un valor.
     *
     * @param key   La clave de la asociación.
     * @param value El valor asociado a la clave.
     */
    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Obtiene la clave de la asociación.
     *
     * @return La clave.
     */
    public K getKey() {
        return key;
    }

    /**
     * Obtiene el valor de la asociación.
     *
     * @return El valor.
     */
    public V getValue() {
        return value;
    }

    /**
     * Establece el valor de la asociación.
     *
     * @param value El nuevo valor a asociar.
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Compara esta asociación con otra, basándose en las claves.
     *
     * @param o La otra asociación con la que se compara.
     * @return Un entero negativo, cero, o un entero positivo si esta asociación es
     *         menor, igual o mayor que la asociación especificada.
     */
    @Override
    public int compareTo(Association<K, V> o) {
        return this.getKey().compareTo(o.getKey());
    }

    /**
     * Retorna una representación en cadena de la asociación.
     *
     * @return Una cadena que representa la asociación.
     */
    @Override
    public String toString() {
        return "(" + key + " " + value + ")";
    }
}
