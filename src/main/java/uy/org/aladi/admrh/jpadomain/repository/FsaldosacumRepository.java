package uy.org.aladi.admrh.jpadomain.repository;

import uy.org.aladi.admrh.jpadomain.entities.Fsaldosacum;

public interface FsaldosacumRepository extends Repository<Fsaldosacum, Integer> {

	Fsaldosacum getByFunc(Short tarjeta);
}
