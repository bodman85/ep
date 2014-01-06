package com.otv;
 
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.otv.hbm.Product;
import com.otv.util.HibernateUtil;
 
/**
 * @author ep.kiev.ua
 * @since 21 Dec 2013
 * @version 1.0.0
 * 
 */

@ManagedBean(name="productMBean")
@ViewScoped
public class ProductManagedBean implements Serializable{
 
	private static final long serialVersionUID = 2781944169997762978L;
	private static Logger log = Logger.getLogger(ProductManagedBean.class);
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

	private int id;
	private String name;
	private String description;
	private String imageFile;
	private BigDecimal price;
	
	private Product selectedProduct;
	
	private String message;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

    public Product getSelectedProduct() {  
        return selectedProduct;  
    }  
  
    public void setSelectedProduct(Product selectedProduct) {  
        this.selectedProduct = selectedProduct;  
        log.debug("Product selected : " + selectedProduct);
    } 
	
    public String getMessage() {
        StringBuffer strBuff = new StringBuffer();
		strBuff.append("id : ").append(id);
		strBuff.append(", name : ").append(name);
		strBuff.append(", description : ").append(description);
		strBuff.append(", price : ").append(price);
        this.setMessage(strBuff.toString());
        return this.message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }  

    public String save() {
        String result = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        Product product = new Product();
        product.setName(this.getName());
        product.setDescription(this.getDescription());
        product.setImageFile(this.getImageFile());
        product.setPrice(this.getPrice());
 
        Transaction tx = null;
 
        try {
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
            log.debug("New Record : " + product + ", wasCommitted : " + tx.wasCommitted());
            result = SUCCESS;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
                result = ERROR;
                e.printStackTrace();
            }
        } finally {
            session.close();
        }
        return result;
    }
    
    public List<Product> getProducts() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Product>  productList = session.createCriteria(Product.class).list();
        log.debug("Total number of products fetched: " + productList.size());
        return productList;
    }
    
    public void reset() {
        this.setName("");
        this.setDescription("");
        this.setImageFile("");
        this.setPrice(new BigDecimal(0.00));
    }
}