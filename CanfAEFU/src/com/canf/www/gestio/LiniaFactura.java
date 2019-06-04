package com.canf.www.gestio;

import java.io.Serializable;

import com.canf.www.articles.Article;
import com.canf.www.articles.TipusExtensio;
import com.canf.www.errors.QuantitatNoDisponibleException;
import com.canf.www.errors.ValidacionException;
import com.canf.www.validacions.Validacions;

public class LiniaFactura implements Serializable {
	private Article article;
	private double preu;
	private int quantitat;

	public LiniaFactura(Article article, int quantitat) throws ValidacionException, QuantitatNoDisponibleException {
		super();
		this.article = article;
		setPreu(article.getPreu());
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
			if (article.getStock() >= quantitat) {
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
	public String toXML() {
		String txtXml = ""+"\n";
			txtXml = txtXml + "<LiniaArticle>" + "\n";
			txtXml = txtXml + "<Article>" + article.getReferencia() + "</Article> " + "\n";
			txtXml = txtXml + "<preu>" + preu + "</preu>" + "\n";
			txtXml = txtXml + "<quantitat>" + quantitat + "</quantitat>" + "\n";
			txtXml = txtXml + "</LiniaArticle>";
		
		return txtXml;
	}

}
