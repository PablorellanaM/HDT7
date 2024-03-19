package com.uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase principal que ejecuta la aplicación del diccionario Inglés-Español.
 * Lee un archivo de diccionario para construir el árbol binario de búsqueda
 * y luego usa este árbol para traducir un archivo de texto del inglés al
 * español.
 */
public class Main {

    /**
     * El punto de entrada de la aplicación.
     * 
     * @param args Los argumentos de la línea de comandos no se utilizan aquí.
     */
    public static void main(String[] args) {
        // Crear una instancia de BinaryTree para el diccionario.
        BinaryTree<String, String> dictionary = new BinaryTree<>();

        // Cargar el archivo diccionario.txt y poblar el árbol.
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Suponemos que cada línea contiene una palabra en inglés y su traducción en
                // español separadas por un espacio y encerradas entre paréntesis.
                String[] parts = line.substring(1, line.length() - 1).split(" ");
                dictionary.insert(parts[0].toLowerCase(), parts[1].toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir el diccionario en orden alfabético de las palabras en inglés.
        System.out.println("Diccionario Inglés-Español:");
        dictionary.inOrder();

        // Traducir texto.txt utilizando el diccionario y imprimir la traducción.
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    // Convertimos cada palabra a minúsculas para la búsqueda en el diccionario.
                    String lowerCaseWord = word.toLowerCase();
                    // Buscamos la traducción en el diccionario.
                    String translation = dictionary.search(lowerCaseWord);
                    // Imprimimos la traducción o la palabra original en inglés si no se encuentra
                    // en el diccionario.
                    System.out.print((translation != null) ? translation : "*" + word + "*");
                    System.out.print(" ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
