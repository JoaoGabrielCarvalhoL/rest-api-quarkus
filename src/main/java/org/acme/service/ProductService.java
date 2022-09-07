package org.acme.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.dto.ProductDTO;
import org.acme.entity.Product;
import org.acme.exception.ProductNotFoundException;
import org.acme.repository.ProductRepository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;

@ApplicationScoped
public class ProductService {

	@Inject
	private ProductRepository productRepository;

	public List<ProductDTO> getAllProducts() {

		PanacheQuery<Product> query = productRepository.findAll();

		List<ProductDTO> result = query
				.stream().map(product -> new ProductDTO(product.getName(), product.getDescription(),
						product.getCategory(), product.getModel(), product.getUnitPrice()))
				.collect(Collectors.toList());

		return result;
	}

	
	public void createProduct(ProductDTO productDto) {

		productRepository.persist(dtoToEntity(productDto));
	}

	public void updateProduct(Long id, ProductDTO dto) {
		Product product = productRepository.findById(id);

		if (product == null) {
			throw new ProductNotFoundException("Product Not Found! Id: " + id);
		}

		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setCategory(dto.getCategory());
		product.setModel(dto.getModel());
		product.setUnitPrince(dto.getUnitPrice());
		productRepository.persist(product);
	}

	public void deleteProduct(Long id) {
		Product product = productRepository.findById(id);

		if (product == null) {
			throw new ProductNotFoundException("Product Not Found! Id: " + id);
		}
		
		productRepository.delete(product);
	}
	
	public ProductDTO findById(Long id) {
		Product product = productRepository.findById(id);

		if (product == null) {
			throw new ProductNotFoundException("Product Not Found! Id: " + id);
		}
		
		return entityToDto(product);

	}

	private Product dtoToEntity(ProductDTO dto) {
		Product product = new Product();
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setCategory(dto.getCategory());
		product.setModel(dto.getModel());
		product.setUnitPrince(dto.getUnitPrice());

		return product;
	}

	private ProductDTO entityToDto(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setName(product.getName());
		dto.setDescription(product.getDescription());
		dto.setCategory(product.getCategory());
		dto.setModel(product.getModel());
		dto.setUnitPrice(product.getUnitPrice());

		return dto;
	}

}
