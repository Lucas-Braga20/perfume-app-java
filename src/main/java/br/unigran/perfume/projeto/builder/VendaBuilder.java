/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unigran.perfume.projeto.builder;

import br.unigran.perfume.projeto.models.Cliente;
import br.unigran.perfume.projeto.models.Funcionario;
import br.unigran.perfume.projeto.models.Venda;
import java.util.Date;

/**
 *
 * @author Unigran
 */
public class VendaBuilder {
    private Date data;
    private Float valor;
    private Cliente cliente;
    private Funcionario funcionario;
    
    public VendaBuilder(Date data, Float valor, Cliente cliente, Funcionario funcionario) {
        this.data = data;
        this.valor = valor;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }
    
    public void validate() throws Exception {
        if (data == null) {
            throw new Exception("Data não pode ser nula.");
        }
        
        if (valor == null) {
            throw new Exception("Valor não pode ser nulo.");
        }
        
        if (cliente == null) {
            throw new Exception("Cliente não pode ser nulo.");
        }
        
        if (funcionario == null) {
            throw new Exception("Funcionário não pode ser nulo.");
        }
    }
    
    public Venda build() throws Exception {
        validate();
        
        Venda venda = new Venda();
        venda.setData(data);
        venda.setFuncionario(funcionario);
        venda.setCliente(cliente);
        venda.setValor(valor);
        
        return venda;
    }
    public Venda build(Venda venda) throws Exception {
        validate();
        
        venda.setData(data);
        venda.setFuncionario(funcionario);
        venda.setCliente(cliente);
        venda.setValor(valor);
        
        return venda;
    }
}
