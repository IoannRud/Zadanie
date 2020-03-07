package classes;

import interfaces.INode;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public class MyStructureTest {
    private Node node = new Node("someCode" , "someRenderer");
    private Node node1 = new Node("someCode1" , "someRenderer1");
    private Node nullNode = new Node(null , null);
    private CompositeNode compositeNodeWithOneInnerNode = new CompositeNode("compositeCodeOneInner" , "compositeRendererOneInner" , Arrays.asList(node,node1));
    private CompositeNode compositeNodeWithSeveralInnerNodes =
            new CompositeNode("compositeCodeSeveralInner" , "compositeRendererSeveralInner" , Arrays.asList(node,node1 , compositeNodeWithOneInnerNode));
    private MyStructure myStructure = new MyStructure(null);

    @Test
    public void count_constructorInMyStructureClassHasNoValues_mustReturnZero() {
        Assertions.assertEquals(0 , myStructure.count());

        myStructure = new MyStructure(new ArrayList<INode>());
        Assertions.assertEquals(0 , myStructure.count());
    }

    @Test
    public void count_constructorInMyStructureClassHasSimpleNodes_mustReturnCountOfTheNodes() {
        myStructure = new MyStructure(Arrays.asList(node));
        Assertions.assertEquals(1, myStructure.count());

        myStructure = new MyStructure(Arrays.asList(node , node1));
        Assertions.assertEquals(2 , myStructure.count());

        myStructure = new MyStructure(Arrays.asList(nullNode , node));
        Assertions.assertEquals(2 , myStructure.count());
    }

    @Test
    public void count_constructorInMyStructureClassHasSimpleAndCompositeNodes_mustReturnCountOfTheNodes() {
        myStructure = new MyStructure(Arrays.asList(node,node1,compositeNodeWithOneInnerNode));
        Assertions.assertEquals(5 , myStructure.count());

        myStructure = new MyStructure(Arrays.asList(node , node1 , compositeNodeWithSeveralInnerNodes));
        Assertions.assertEquals(8 , myStructure.count());
    }

    @Test
    public void findByCode_AssertThatTheParameterIsNullInEmptyArray_mustReturnNull() {
        myStructure = new MyStructure(new ArrayList<>());
        Assertions.assertNull(myStructure.findByCode(null));
    }

    @Test
    public void findByCode_constructorInMyStructureClassHasSingleAndCompositeNodes_mustReturnSimpleNodesIfTheyExist(){
        myStructure = new MyStructure(Arrays.asList(node));
        Assertions.assertEquals(node , myStructure.findByCode("someCode"));

        myStructure = new MyStructure(Arrays.asList(node , node1 , nullNode , compositeNodeWithOneInnerNode , compositeNodeWithSeveralInnerNodes));
        Assertions.assertEquals(node1 , myStructure.findByCode("someCode1"));
        Assertions.assertEquals(nullNode , myStructure.findByCode(null));
        Assertions.assertEquals(compositeNodeWithOneInnerNode , myStructure.findByCode("compositeCodeOneInner"));
        Assertions.assertEquals(compositeNodeWithSeveralInnerNodes , myStructure.findByCode("compositeCodeSeveralInner"));

    }

    @Test
    public void findByRenderer_AssertThatTheParameterIsNullInEmptyArray_mustReturnNull(){
        myStructure = new MyStructure(new ArrayList<>());
        Assertions.assertNull(myStructure.findByRenderer(null));
    }

    @Test
    public void findByRenderer_constructorInMyStructureClassHasSingleAndCompositeNodes_mustReturnSimpleNodesIfTheyExist(){
        myStructure = new MyStructure(Arrays.asList(node));
        Assertions.assertEquals(node , myStructure.findByRenderer("someRenderer"));

        myStructure = new MyStructure(Arrays.asList(node , node1 , nullNode , compositeNodeWithOneInnerNode , compositeNodeWithSeveralInnerNodes));
        Assertions.assertEquals(node1 , myStructure.findByRenderer("someRenderer1"));
        Assertions.assertEquals(nullNode , myStructure.findByRenderer(null));
        Assertions.assertEquals(compositeNodeWithOneInnerNode , myStructure.findByRenderer("compositeRendererOneInner"));
        Assertions.assertEquals(compositeNodeWithSeveralInnerNodes , myStructure.findByRenderer("compositeRendererSeveralInner"));
    }
}