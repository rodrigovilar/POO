import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class JogoTest {
	
	Jogo jogo;
	@Before
	public void iniciar() {
		jogo = new Jogo();
	}	
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
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void lerPecaEmCelulaDesocupada() {
		jogo.setJogador(true);
		jogo.isPecaNaPosicao(0,1);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void lerPecaEmColunaErrada() {
		jogo.setJogador(true);
		jogo.isPecaNaPosicao(1, 20);
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void lerPecaEmLinhaErrada() {
		jogo.setJogador(true);
		jogo.isPecaNaPosicao(20, 1);
	}
	@Test 
	public void colocarNaviuDeUmCano() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeUmCano(0, 1);
		assertTrue("esperava naviu de um cano na posicao 0,1", jogo.isPecaNaPosicao(0, 1));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviusDeUmCanoAlemDoMaximoDeQuatro() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeUmCano(0, 1);
		jogo.colocarNaviuDeUmCano(0, 2);
		jogo.colocarNaviuDeUmCano(0, 3);
		jogo.colocarNaviuDeUmCano(0, 4);
		jogo.colocarNaviuDeUmCano(0, 5);
	}
	@Test 
	public void colocarNaviuDeDoisCanosNaHorizontal() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeDoisCanos(0, 1, "horizontal");
		assertTrue("esperava peca na posicao (0, 1) e (0, 2)", jogo.isPecaNaPosicao(0, 1) && jogo.isPecaNaPosicao(0, 2));
	}
	@Test
	public void colocarNaviuDeDoisCanosNaVertical() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeDoisCanos(0,  1, "vertical");
		assertTrue("esperava peca na posicao (0, 1) e (1,1)", jogo.isPecaNaPosicao(0, 1) && jogo.isPecaNaPosicao(1, 1));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviuDeDoisCanosHorizontalNaUltimaLinha() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeDoisCanos(0, 9, "horizontal");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviuDeDoisCanosVerticalNaUltimaColuna() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeDoisCanos(9, 9, "vertical");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviusDeDoisCanosAlemDoMaximoDeTres() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeDoisCanos(0, 0, "horizontal");
		jogo.colocarNaviuDeDoisCanos(2, 2, "vertical");
		jogo.colocarNaviuDeDoisCanos(4, 4, "horizontal");
		jogo.colocarNaviuDeDoisCanos(6, 6, "vertical");
	}
	@Test
	public void colocarNaviuDeTresCanosNaHorizontal() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeTresCanos(0, 0, "horizontal");
		assertTrue("esperava peca na posicao (0, 0), (0, 1) e (0, 2)", jogo.isPecaNaPosicao(0, 0) 
				&& jogo.isPecaNaPosicao(0, 1) && jogo.isPecaNaPosicao(0, 2));
	}
	@Test
	public void colocarNaviuDeTresCanosNaVertical() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeTresCanos(0, 0, "vertical");
		assertTrue("esperava peca na posicao (0, 0), (1, 0) e (2, 0)", jogo.isPecaNaPosicao(0, 0) 
				&& jogo.isPecaNaPosicao(1, 0) && jogo.isPecaNaPosicao(2, 0));
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviuDeTresCanosHorizontalNaPenultimaLinha() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeTresCanos(8, 8, "horizontal");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviuDeTresCanosVerticalNaPenultimaColuna() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeTresCanos(8, 8, "vertical");
	}
	@Test (expected=ExcecaoBatalhaNaval.class)
	public void colocarNaviusDeDoisCanosAlemDoMaximoDeDois() {
		jogo.setJogador(true);
		jogo.colocarNaviuDeTresCanos(0, 0, "horizontal");
		jogo.colocarNaviuDeTresCanos(1, 0, "horizontal");
		jogo.colocarNaviuDeTresCanos(3, 0, "horizontal");
	}	
}
