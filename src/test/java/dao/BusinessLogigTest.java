package dao;

import org.junit.Test;

public class BusinessLogigTest {

    private final BusinessLogic businessLogic = new BusinessLogic();

    @Test
    public void test() {
        businessLogic.getListaUsuario().forEach(System.out::println);
    }

}
