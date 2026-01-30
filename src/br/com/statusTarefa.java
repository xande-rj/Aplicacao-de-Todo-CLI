public enum statusTarefa {
  CONCLUIDO("CONCLUIDO"),
  EM_ANDAMENTO("EM_ANDAMENTO"),
  NAO_CONCLUIDO("NAO_CONCLUIDO");

  private String status;

  statusTarefa(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}
