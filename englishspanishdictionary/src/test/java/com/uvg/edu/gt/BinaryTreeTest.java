package com.uvg.edu.gt;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeTest {

    private BinaryTree<String, String> dictionary;

    @Before
    public void setUp() {
        // Inicializar el diccionario antes de cada prueba.
        dictionary = new BinaryTree<>();
        dictionary.insert("house", "casa");
        dictionary.insert("dog", "perro");
        dictionary.insert("homework", "tarea");
        dictionary.insert("woman", "mujer");
        dictionary.insert("town", "pueblo");
        dictionary.insert("yes", "si");
    }

    @Test
    public void whenInserted_thenKeyShouldExist() {
        // Insertar y luego buscar para ver si la clave existe.
        assertNotNull("La clave debería existir.", dictionary.search("house"));
    }

}
