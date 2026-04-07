package dev.rayh;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        LinkedList<Integer> list = new LinkedList<>(List.of(1, 3, 5, 7, 9));

        System.out.println(list.get(1));

        //adicionar um elemento no index

        list.add(1,2);

        //remover primeiro item da lista

        Integer i = list.removeFirst();

        System.out.printf("item removido: %s, lista atual: %s\n", i, list);
    }
}
