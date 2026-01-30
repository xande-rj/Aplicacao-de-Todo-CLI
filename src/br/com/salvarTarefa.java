import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class salvarTarefa {
  public LocalDate dia = LocalDate.now();
  public File arquivoCriado = criarArquivo();

  public void criarPastaPai() {
    File caminhoPai = new File("pastaSalvar");
    if (!caminhoPai.exists()) {
      try {
        caminhoPai.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  public File criarArquivo() {
    File arquivo = new File("pastaSalvar/Tarefas_dia_" + dia.toString() +
        ".txt");
    if (!arquivo.exists()) {
      try {
        arquivo.createNewFile();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return arquivo;
  }

  public void escreverArquivo(File arquivoCriado, String info) {
    try (FileWriter fw = new FileWriter(arquivoCriado, true)) {

      fw.write(info + System.lineSeparator());
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void salvar(String info) {

    criarPastaPai();

    escreverArquivo(arquivoCriado, info);
  }

  public void deletarInfoArquivo(File arquivoCriado) {

    try {
      new FileWriter(arquivoCriado, false).close();
    } catch (

    IOException e) {
      e.printStackTrace();
    }
  }

}
