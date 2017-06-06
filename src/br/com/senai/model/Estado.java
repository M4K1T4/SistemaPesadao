package br.com.senai.model;
// Classe Enum para manter valores que nunca irão mudar, nesse caso estados//
public enum Estado {
	
	AC("Acre","AC"),
	AL("Alagoas","AL"),
	AP ("Amapá","AP"),
	AM("Amazonas","AM"),
	BA ("Bahia","BA"),
	CE ("Ceará","CE"),
	DF("Distrito Federal","DF"),
	ES ("Espírito Santo","ES"),
	GO ("Goiás","GO"),
	MA ("Maranhão","MA"),
	MT ("Mato Grosso","MT"),
	MS ("Mato Grosso do Sul","MS"),
	MG ("Minas Gerais","MG"),
	PA ("Pará","PA"),
	PR("Paraná","PR"),
	PB ("Paraíba","PB"),
	PE ("Pernambuco","PE"),
	PI ("Piauí","PI"),
	RR("Roraima", "RR"),
	RO ("Rondônia", "RO"),
	RJ ("Rio de Janeiro", "RJ"),
	RN ("Rio Grande do Norte", "RN"),
	RS ("Rio Grande do Sul", "RS"),
	SC ("Santa Catarina", "SC"),
	SP("São Paulo", "SP"),
	SE ("Sergipe","SE"),
	TO("Tocantins","TO");
	
	private String label;
	private String sigla;
	
	private Estado(String label,String sigla){
		this.label=label;
		this.sigla=sigla;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
}
