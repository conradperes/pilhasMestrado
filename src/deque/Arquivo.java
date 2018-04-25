package deque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {

	private static final String PATH_ARQUIVO = System.getProperty("user.dir") + "/sidin.txt";
	private static final int N = 1000;

	public static void main(String[] args) {
		Arquivo arquivo = new Arquivo();
		try {
			arquivo.gravaArquivo();
			arquivo.leituraArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void gravaUTFArquivo() {
		try {
			File fileDir = new File(PATH_ARQUIVO);
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileDir), "UTF8"));
			out.append("Website UTF-8").append("\r\n");
			out.append("?? UTF-8").append("\r\n");
			out.append("??????? UTF-8").append("\r\n");
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Método que grava os números no arquivo
	 * 
	 * @throws IOException
	 *             Dispara exceção de arquivo não encontrado
	 */
	public void gravaArquivo() throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(PATH_ARQUIVO))) {
			for (String i : getNumerosNaturais()) {
				bw.write(i + "\n");
			}
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void test() throws IOException {
		String path = System.getProperty("user.dir");
		new File(path + "/wiki.txt").createNewFile();
		Path myText_path = Paths.get(path);
		Charset charset = Charset.forName("UTF-8");
		ArrayList<String> lines = new ArrayList<>();
		lines.add("\n");
		lines.add("tutorial");

		try {
			Files.write(myText_path, lines, charset, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.err.println(e);
		}
		// Path path = Paths.get(PATH_ARQUIVO);
		// // Charset utf8 = StandardCharsets.UTF_8;
		// Charset charset = Charset.forName("UTF-8");
		// // BufferedWriter escritor = null;
		// //
		// // escritor = Files.newBufferedWriter(path, utf8);
		//
		// Files.write(path, getNumerosNaturais(), charset, StandardOpenOption.APPEND);
		// escritor.flush();

	}

	public List<String> pegarTodasLinhasArquivo() throws IOException {
		Path path = Paths.get(PATH_ARQUIVO);
		return Files.readAllLines(path);
	}

	public ArrayList<Byte> getNumerosBytes() {
		ArrayList<Byte> sequence = new ArrayList<Byte>();
		for (byte i = 0; i < N; i++) {
			sequence.add(i);
		}
		return sequence;
	}

	public ArrayList<String> getNumerosNaturais() {
		ArrayList<String> lines = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			lines.add("" + i);
		}
		lines.add("-1");
		return lines;
	}

	public ArrayList<String> getNumerosNaturais(int[] inteiros) {
		ArrayList<String> lines = new ArrayList<String>();
		for (int i = 0; i < inteiros.length; i++) {
			lines.add("" + inteiros[i]);
		}
		return lines;
	}

	public void leituraArquivo() {
		BufferedReader br = null;
		FileReader fr = null;
		try {
			// br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(PATH_ARQUIVO);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while (br!=null && (sCurrentLine = br.readLine()) != null) {
				if (sCurrentLine.equalsIgnoreCase("-1")) {
					System.out.println("Chegou ao final do arquivo!!!!");
					fechaArquivo(br, fr);
					br = null;
					fr = null;
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void fechaArquivo(BufferedReader br, FileReader fr) {
		try {
			if (br != null)
				br.close();
			if (fr != null)
				fr.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
