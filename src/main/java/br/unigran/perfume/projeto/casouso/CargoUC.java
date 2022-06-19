/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.casouso;

import br.unigran.perfume.projeto.builder.CargoBuilder;
import br.unigran.perfume.projeto.models.Cargo;
import br.unigran.perfume.projeto.persistence.GenericoDAO;
import java.util.List;

/**
 *
 * @author Unigran
 */
public final class CargoUC {
    private static final GenericoDAO<Cargo> DAO = new GenericoDAO<Cargo>();
    
    public static Cargo salvar(CargoBuilder cargoBuilder) throws Exception {
        Cargo cargo = cargoBuilder.build();
        cargo = DAO.salvar(cargo, cargo.getId());
        return cargo;
    }
    
    public static Cargo atualizar(CargoBuilder cargoBuilder, Cargo cargo) throws Exception {
        Cargo anterior = cargoBuilder.build(cargo);
        Cargo atualizado = DAO.salvar(cargo, anterior.getId());
        return atualizado;
    }
    
    public static void remover(Integer id) throws Exception {
        DAO.remover(id, Cargo.class);
    }
    
    public static List<Cargo> listar() throws Exception {
        List<Cargo> cargos = DAO.listar(Cargo.class);
        return cargos;
    }
}
