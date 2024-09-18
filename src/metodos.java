import java.io.File;
import java.io.IOException;

public class metodos {
    String dirName;
    String fileName;
    File directorio = new File(dirName, fileName);

    public static void eDirectorio(String cadea) {
        File novoArchivo = new File(cadea);
        if (novoArchivo.isDirectory()) {
            System.out.println("E un directório");
        } else {
            System.out.println("Non e un directório");
        }
    }

    public static void eFicheiro(String cadea) {
        File novoFicheiro = new File(cadea);
        if (novoFicheiro.isFile()) {
            System.out.println("E un ficheiro");
        } else {
            System.out.println("Non e un ficheiro");
        }
    }

    public static void crearDirectorio(String directorio) {
        File novoDirectorio = new File(directorio);
        if (!novoDirectorio.exists()) {
            if (novoDirectorio.mkdir()) {
                System.out.println("Directorio creado con éxito: " + directorio);
            } else {
                System.out.println("Non se puido crear o directorio: " + directorio);
            }
        } else {
            System.out.println("O directório xa existe");
        }
    }

    public static void creaFicheiro(String dirName, String fileName, File directorio) {
        if (directorio.exists() && directorio.isDirectory()) {
            File ficheiro = new File(directorio, fileName);
            if (!ficheiro.exists()) {
                try {
                    if (ficheiro.createNewFile()) {
                        System.out.println("Ficheiro creado con éxito: " + ficheiro.getAbsolutePath());
                    } else {
                        System.out.println("Non se puido crear o ficheiro.");
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao crear o ficheiro: " + e.getMessage());
                }
            } else {
                System.out.println("O ficheiro xa existe: " + ficheiro.getAbsolutePath());
            }
        } else {
            System.out.println("O directorio non existe ou non é válido.");
        }
    }

    public static void modoAcceso(String dirName, String fileName,File directorio) {
        if (directorio.canWrite()) {
            System.out.println("escritura si");
        } else {
            System.out.println("escritura non");
        }
        if (directorio.canRead()) {
            System.out.println("lectura si");
        } else {
            System.out.println("lectura non");
        }
        if (directorio.exists()) {
            System.out.println("Lonxitude do arquivo " + directorio.length());
        } else {
            System.out.println("O arquivo non existe");
        }
    }

    public static void calculaLonxitude(String dirName, String fileName,File directorio) {
        if (directorio.exists()) {
            System.out.println("A lonxitude do arquivo e: " + directorio.length());
        } else {
            System.out.println("O arquivo non existe");
        }
    }

    public static void mLectura(String dirName, String fileName,File directorio) {
        if (directorio.exists()) {
            directorio.setReadOnly();
            System.out.println("O arquivo pasóu a ser so de lectura");
        } else {
            System.out.println("O arquivo non existe");
        }
    }

    public static void mEscritura(String dirName, String fileName,File directorio) {
        if (directorio.exists()) {
            System.out.println("O arquivo pasóu a ser de lectura e escritura");
        } else {
            System.out.println("O arquivo non existe");
        }
    }

    public static void borraFicheiro(String dirName, String fileName,File directorio) {
        if (directorio.exists()) {
            boolean result = directorio.delete();
            if (result) {
                System.out.println("O arquivo foi eliminado");
            } else {
                System.out.println("o arquivo non se puido eliminar");
            }
        } else {
            System.out.println("o ficheiro non existe");
        }

    }

    public static void borraDirectorio(String dirName) {
        File dir = new File(dirName);
        if(dir.exists() && dir.isDirectory()){
            dir.delete();
            System.out.println("Directório eliminado");
        }else{
            System.out.println("ruta inexistente ou con descencencia");
        }
    }

    public static void mContido(String dirName) {
        File dir = new File(dirName);
        if (dir.exists() && dir.isDirectory()) {
            File[] contenido = dir.listFiles();
            if (contenido != null && contenido.length > 0) {
                System.out.println("Contido do directorio: " + dirName);
                for (File item : contenido) {
                    if (item.isDirectory()) {
                        System.out.println("[Directorio] " + item.getName());
                    } else if (item.isFile()) {
                        System.out.println("[Arquivo] " + item.getName());
                    }
                }
            } else {
                System.out.println("O directorio está baleiro");
            }
        } else {
            System.out.println("Ruta inexistente ou non é un directorio");
        }
    }

}
