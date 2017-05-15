package ho.app.product.book;

import ho.app.product.book.api.IBook;

public class Book implements IBook{
	private final int id;
	private final String ISBN;
	private final String title;
	private final double unitPrice;
	private final String author;
	private final String volume;
	
	private Book(int id, String ISBN, String title, double unitPrice, String author, String volume) {
		this.id = id;
		this.ISBN = ISBN;
		this.title = title;
		this.unitPrice = unitPrice;
		this.author = author;
		this.volume = volume;
	}
	
	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getISBN() {
		return this.ISBN;
	}

	@Override
	public double getUnitPrice() {
		return this.unitPrice;
	}
	
	@Override
	public String getAuthor() {
		return this.author;
	}

	@Override
	public String getVolume() {
		return this.volume;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		long temp;
		temp = Double.doubleToLongBits(unitPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((volume == null) ? 0 : volume.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Book other = (Book)obj;
		if (id != other.id)
			return false;
		return true;
	}



	public static class BuilderBook {
		private int id;
		private String ISBN;
		private String title;
		private double unitPrice;
		private String author;
		private String volume;
		
		public BuilderBook Id(int id) {
			this.id = id;
			return this;
		}
		
		public BuilderBook ISBN(String isbn) {
			this.ISBN = isbn;
			return this;
		}
		
		public BuilderBook Title(String title) {
			this.title = title;
			return this;
		}
		
		public BuilderBook UnitPrice(double unitPrice) {
			this.unitPrice = unitPrice;
			return this;
		}
		
		public BuilderBook Author(String author) {
			this.author = author;
			return this;
		}
		
		public BuilderBook Volume(String volume) {
			this.volume = volume;
			return this;
		}
		
		
		public Book build() {
			return new Book(id, ISBN, title, unitPrice, author, volume);
		}
	}

}
