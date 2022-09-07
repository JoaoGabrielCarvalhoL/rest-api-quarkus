package org.acme.controller;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.acme.dto.ProductDTO;
import org.acme.service.ProductService;

@Path("/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
	
	private ProductService productService;
	
	@Inject
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@Transactional
	@POST
	public Response createProduct(ProductDTO dto) {
		productService.createProduct(dto);
		return Response.status(Status.CREATED).build();
	}
	
	@Transactional
	@DELETE
	@Path("/{id}")
	public Response deleteProduct(Long id) {
		productService.deleteProduct(id); 
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@GET
	@Path("/{id}")
	public Response findProductById(@PathParam("id") Long id) {
		ProductDTO dto = productService.findById(id);
		return Response.status(Status.OK).entity(dto).build();
	}
	
	@GET
	public Response findAll() {
		List<ProductDTO> products = productService.getAllProducts();
		return Response.status(Status.OK).entity(products).build();
	}
	
	@Transactional
	@PUT
	@Path("/{id}")
	public Response updateProduct(@PathParam("id") Long id, ProductDTO dto) {
		productService.updateProduct(id, dto); 
		return Response.status(Status.NO_CONTENT).build();
	}

}
