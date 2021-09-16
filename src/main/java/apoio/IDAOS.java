/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.util.ArrayList;

/**
 *
 * @author Gui
 */
public interface IDAOS <S> {

    public String salvar(S o);

    public String atualizar(S o);

    public String excluir(int id);

    public ArrayList<S> consultarTodos();

    public ArrayList<S> consultar(String criterio);

    public S consultarId(int id);
}
    
