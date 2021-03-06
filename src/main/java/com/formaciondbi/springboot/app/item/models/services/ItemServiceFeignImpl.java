package com.formaciondbi.springboot.app.item.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formaciondbi.springboot.app.item.clientes.IProductoClienteRest;
import com.formaciondbi.springboot.app.item.models.Item;
import com.formaciondbi.springboot.app.commons.models.entity.Producto;

@Service("serviceFeign")
@Primary
public class ItemServiceFeignImpl implements ItemService {
	
	@Autowired
	private IProductoClienteRest clienteFeign;
	
	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad);
	}

	@Override
	public Producto save(Producto producto) {
		return clienteFeign.crear(producto);
	}

	@Override
	public Producto update(Long id, Producto producto) {
		return clienteFeign.editar(id, producto);
	}

	@Override
	public void delete(Long id) {
		clienteFeign.eliminar(id);		
	}

}
