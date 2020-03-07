# Zadanie

interface IMyStructure {
  // zwraca węzeł o podanym kodzie lub null
  INode findByCode(String code);
  // zwraca węzeł o podanym rendererze lub null
  INode findByRenderer(String renderer);
  //zwraca liczbę węzłów
  int count();
}

public class MyStructure implements IMyStructure {
  private List<INode> nodes;
}

interface INode {
  String getCode();
  String getRenderer();
}

interface ICompositeNode extends INode {
  List<INode> getNodes();
}
