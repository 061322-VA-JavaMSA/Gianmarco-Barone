package project0ShopModels;

import java.util.Objects;

public class product {

		private String productStatus;
		private String productName;
		private int productPrice;
		private customer customerassigned;
		public product() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String getProductStatus() {
			return productStatus;
		}
		public void setProductStatus(String productStatus) {
			this.productStatus = productStatus;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}
		public customer getCustomerassigned() {
			return customerassigned;
		}
		public void setCustomerassigned(customer customerassigned) {
			this.customerassigned = customerassigned;
		}
		@Override
		public int hashCode() {
			return Objects.hash(customerassigned, productName, productPrice, productStatus);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			product other = (product) obj;
			return Objects.equals(customerassigned, other.customerassigned)
					&& Objects.equals(productName, other.productName) && productPrice == other.productPrice
					&& Objects.equals(productStatus, other.productStatus);
		}
		@Override
		public String toString() {
			return "product [productStatus=" + productStatus + ", productName=" + productName + ", productPrice="
					+ productPrice + ", customerassigned=" + customerassigned + "]";
		}
		
}
