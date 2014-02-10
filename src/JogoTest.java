import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class JogoTest {
	//todos os 7 testes passaram.
	
	Jogo jogo = new Jogo();
	
	@Test
	public void criaJogo() {
		assertFalse("o jogo comecou no fim", jogo.acabou());
	}
	@Test
	public void definirPrimeiroJogador() {
		jogo.setJogador(true);
		assertTrue("esperava primeiro jogador true", jogo.isJogador());
	}
	@Test 
	public void definirPrimeiroJogadorDeNovo() {
		jogo.setJogador(true);
		jogo.setJogador(false);
		assertFalse("esperava 1o jogador false", jogo.isJogador());
	}
	@Test 
	public void colocarPrimeiraPeca() {
		jogo.setJogador(true);
		jogo.colocarPeca(0, 1);
		assertTrue("esperava primeira peca na posicao 0,1", jogo.isPecaNaPosicao(0, 1));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocaPecaEmCelulaOcupada() {
		jogo.setJogador(true);
		jogo.colocarPeca(0, 1);
		jogo.colocarPeca(0, 1);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarPecaEmColunaErrada() {
		jogo.setJogador(true);
		jogo.colocarPeca(1, 20);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarPecaEmLinhaErrada() {
		jogo.setJogador(true);
		jogo.colocarPeca(20, 1);
	}
	

	
	
	
	
}
