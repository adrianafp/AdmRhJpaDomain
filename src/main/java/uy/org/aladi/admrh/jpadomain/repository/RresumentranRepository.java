package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Rresumentran;


public interface RresumentranRepository extends Repository<Rresumentran, Long>{
	String deleteAll();
	Rresumentran getByTarjetaCodigoyAniomes(Short tarjeta, Short idcod, String aniomes);
}
