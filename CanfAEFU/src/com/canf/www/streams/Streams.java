package com.canf.www.streams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.canf.www.articles.Article;
import com.canf.www.gestio.Magatzem;

public class Streams {
	public static void escriuMagatzem(String desti, Magatzem magatzem) {
		try (ObjectOutputStream p = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(desti)));) {
			p.writeObject(magatzem);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void escriuArticle(String desti, Article article) {
		try (ObjectOutputStream p = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(desti)));) {
			p.writeObject(article);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Magatzem llegeixMagatzem(String origen) {
		Magatzem magatzem = null;
		try (ObjectInputStream p = new ObjectInputStream(new BufferedInputStream(new FileInputStream(origen)));) {

			try {
				while (true) {
					magatzem = ((Magatzem) p.readObject());
				}
			} catch (EOFException e) {

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return magatzem;
	}
	public static Article llegeixArticle(String origen) {
		Article article = null;
		try (ObjectInputStream p = new ObjectInputStream(new BufferedInputStream(new FileInputStream(origen)));) {

			try {
				while (true) {
					article = ((Article) p.readObject());
				}
			} catch (EOFException e) {

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return article;
	}
}
