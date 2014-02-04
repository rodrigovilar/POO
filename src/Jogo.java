
public class Jogo {
	
	private Boolean jogadorDaVez;
	private Boolean[][] tabuleiro = new Boolean[10][10];

	public boolean acabou() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setJogador(boolean jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
	}

	public boolean isJogador() {
		// TODO Auto-generated method stub
		return jogadorDaVez;
	}

	public void colocarPeca(int linha, int coluna) {

		if (coluna < 0 || coluna > 9) {
			throw new ExcecaoBatalhaNaval("coluna fora da faixa permitida");
		}
		if (linha < 0 || linha > 9) {
			throw new ExcecaoBatalhaNaval("linha fora da faixa permitida");
		}
		if (tabuleiro[linha][coluna] != null) {
			throw new ExcecaoBatalhaNaval("Celula ocupada");
		}
		tabuleiro[linha][coluna] = jogadorDaVez;
	}

	public boolean isPecaNaPosicao(int linha, int coluna) {
		return tabuleiro[linha][coluna] == true;
	}
	
	
	

}
