package br.com.sitedoph;

import br.com.sitedoph.model.Linha;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Abre o arquivo,
 * Carrega o conteúdo,
 * Faz um split em cada linha,
 * Faz um match Regex,
 * Utiliza o match para extrair as informações desejadas,
 * Cria o objeto linha com essas informações,
 * Imprime o resultado!
 */
public class App {
    public static void main(String[] args) throws IOException {

        // * Abre o arquivo,
        JFileChooser chooser = new JFileChooser();
        File f = new File(".");
        chooser.setCurrentDirectory(f);

        int checker = chooser.showOpenDialog(null);

        final File selectedFile;

        if (checker == JFileChooser.APPROVE_OPTION) {
            selectedFile = chooser.getSelectedFile();
            System.out.println(selectedFile);
        } else {
            throw new RuntimeException("Choose some file!!!");
        }

        //* Carrega o conteúdo,
        String content = new String(Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath())));

        //Faz um split em cada linha
        String[] split = content.split("\r\n");

        final String regex = "(\\d\\d.\\d\\d\\d.\\d\\d\\d/(\\d|\\w)-(\\d|\\w)  )(.{30})(\\d\\d\\/\\d\\d\\d.\\d\\d\\d.\\d\\d\\d.\\d(\\s*))(\\d{0,1})(\\s*)(.*)";
        Pattern pattern = Pattern.compile(regex);

        List<Linha> linhas = new ArrayList<>();

        for (String linhaString : split) {

            //* Faz um match Regex,
            Matcher matcher = pattern.matcher(linhaString);
            Linha linha = null;

            if (matcher.find()) {
                //* Utiliza o match para extrair as informações desejadas,
                final String id_I = matcher.group(1).trim();
                final String nome = matcher.group(4).trim();
                final String id_II = matcher.group(5).trim();
                final String digito = matcher.group(7).trim();
                final String motivo = matcher.group(9).trim();

                //* Cria o objeto linha com essas informações,
                linha = new Linha(id_I, nome, id_II, digito, motivo);
            }

            linhas.add(linha);
        }

        // imprime o resultado!
        System.out.println(linhas);
    }
}
