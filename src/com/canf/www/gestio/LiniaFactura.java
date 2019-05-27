package com.canf.www.gestio;

import com.canf.www.articles.Article;
import com.canf.www.errors.QuantitatNoDisponibleException;
import com.canf.www.errors.ValidacionException;
import com.canf.www.validacions.Validacions;

public class LiniaFactura {
	private Article article;
	private double preu;
	private int quantitat;

	public LiniaFactura(Article article, int quantitat) throws ValidacionException, QuantitatNoDisponibleException {
		super();
		this.article = article;
		setPreu(preu);
		setQuantitat(quantitat);

	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) throws ValidacionException {
		if (Validacions.validaDouble(preu))
			this.preu = preu;
		else
			throw new ValidacionException("No pot ser menor que 0.");
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) throws ValidacionException, QuantitatNoDisponibleException {
		if (Validacions.validaInt(quantitat)) {
			if (article.getStock() > quantitat) {
				this.quantitat = quantitat;
				article.setStock(article.getStock() - quantitat);
			} else {
				throw new QuantitatNoDisponibleException("Quantitat no disponible.");
			}

		} else
			throw new ValidacionException("No pot ser menor que 0.");
	}

	public Article getArticle() {
		return article;
	}

	@Override
	public String toString() {
		return "LiniaFactura [article=" + article + ", preu=" + preu + ", quantitat=" + quantitat + "]";
	}

}
