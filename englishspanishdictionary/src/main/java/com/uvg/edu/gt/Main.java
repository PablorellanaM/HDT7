package com.uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de BinaryTree para el diccionario.
        BinaryTree<String, String> dictionary = new BinaryTree<>();

        // Cargar el archivo diccionario.txt y poblar el árbol.
        // (Este código supone que el archivo diccionario.txt está en el mismo
        // directorio que tu proyecto)
        try (BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.substring(1, line.length() - 1).split(" ");
                dictionary.insert(parts[0].toLowerCase(), parts[1].toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir el diccionario en orden.
        System.out.println("Diccionario Inglés-Español:");
        dictionary.inOrder();

        // Traducir texto.txt utilizando el diccionario.
        // PORFA PON LA DIRECCION DEL DIRECTORIO DEL ARCHIVO TXT, PARA QUE EL PROGRAMA
        // SE PUEDA EJECUTAR BIEN :)
        try (BufferedReader br = new BufferedReader(new FileReader("texto.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String lowerCaseWord = word.toLowerCase();
                    String translation = dictionary.search(lowerCaseWord);
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
