package com.coffe.aguardad.coffetime;


import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Historial {

   /* File sdCard, directory, file = null;

    public Historial(){

    }

    //http://www.javaya.com.ar/androidya/androidstudioya/detalleconcepto.php?codigo=15&inicio=0

    public void writeFile(){
        try {
            // validamos si se encuentra montada nuestra memoria externa
            if (Environment.getExternalStorageState().equals("mounted")) {

                // Obtenemos el directorio de la memoria externa
                sdCard = Environment.getExternalStorageDirectory();

                if (arg0.equals(btnGuardar)) {
                    String str = txtTexto.getText().toString();

                    // Clase que permite grabar texto en un archivo
                    FileOutputStream fout = null;
                    try {
                        // instanciamos un onjeto File para crear un nuevo
                        // directorio
                        // la memoria externa
                        directory = new File(sdCard.getAbsolutePath()
                                + "/Mis archivos");
                        // se crea el nuevo directorio donde se cerara el
                        // archivo
                        directory.mkdirs();

                        // creamos el archivo en el nuevo directorio creado
                        file = new File(directory, "MiArchivo.txt");

                        fout = new FileOutputStream(file);

                        // Convierte un stream de caracteres en un stream de
                        // bytes
                        OutputStreamWriter ows = new OutputStreamWriter(fout);
                        ows.write(str); // Escribe en el buffer la cadena de texto
                        ows.flush(); // Volca lo que hay en el buffer al archivo
                        ows.close(); // Cierra el archivo de texto

                        Toast.makeText(getBaseContext(),
                                "El archivo se ha almacenado!!!",
                                Toast.LENGTH_SHORT).show();

                        txtTexto.setText("");

                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }

            }else{
                Toast.makeText(getBaseContext(),
                        "El almacenamineto externio no se encuentra disponible",
                        Toast.LENGTH_LONG).show();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void ReadFile() {
        try {
            // validamos si se encuentra montada nuestra memoria externa
            if (Environment.getExternalStorageState().equals("mounted")) {

                // Obtenemos el directorio de la memoria externa
                sdCard = Environment.getExternalStorageDirectory();

                if (arg0.equals(btnAbrir)) {
                    try {

                        //Obtenemos el direcorio donde se encuentra nuestro archivo a leer
                        directory = new File(sdCard.getAbsolutePath()
                                + "/Mis archivos");

                        //Creamos un objeto File de nuestro archivo a leer
                        file = new File(directory, "MiArchivo.txt");

                        //Creamos un objeto de la clase FileInputStream
                        //el cual representa un stream del archivo que vamos a leer
                        FileInputStream fin = new FileInputStream(file);

                        //Creaos un objeto InputStreamReader que nos permitira
                        //leer el stream del archivo abierto
                        InputStreamReader isr = new InputStreamReader(fin);

                        char[] inputBuffer = new char[READ_BLOCK_SIZE];
                        String str = "";

                        // Se lee el archivo de texto mientras no se llegue al
                        // final
                        // de él
                        int charRead;
                        while ( (charRead = isr.read(inputBuffer)) & gt;
                        0){
                            // Se lee por bloques de 100 caracteres
                            // ya que se desconoce el tamaño del texto
                            // Y se va copiando a una cadena de texto
                            String strRead = String.copyValueOf(inputBuffer, 0,
                                    charRead);
                            str += strRead;

                            inputBuffer = new char[READ_BLOCK_SIZE];
                        }

                        // Se muestra el texto leido en la caje de texto
                        txtTexto.setText(str);

                        isr.close();

                        Toast.makeText(getBaseContext(),
                                "El archivo ha sido cargado",
                                Toast.LENGTH_SHORT).show();

                    } catch (IOException e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }

                }
            } else {
                Toast.makeText(getBaseContext(),
                        "El almacenamineto externio no se encuentra disponible",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/

}
