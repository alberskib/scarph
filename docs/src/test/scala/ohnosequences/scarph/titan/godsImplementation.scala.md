
```scala
package ohnosequences.scarph.test.titan

import GodsSchema._

object GodsImplementation {
```


### Vertices


```scala
  case object titan    extends TVertex(Titan)
  case object god      extends TVertex(God)
  case object demigod  extends TVertex(Demigod)
  case object human    extends TVertex(Human)
  case object monster  extends TVertex(Monster)
  case object location extends TVertex(Location)

  case object alternativeTitan extends TitanImpl with AnyTVertex {

    import ohnosequences.scarph.AnyEdge

    implicit val _name: GetProperty[name.type] = unsafeGetProperty(name)
    implicit val _age:  GetProperty[age.type] = unsafeGetProperty(age)

    implicit def fatherIn[
      E <: Singleton with AnyEdge { type Tpe = TitanFather.type }
    ](e: E): RetrieveInEdge[E] = unsafeRetrieveManyInEdge[E](e)
  }
```


### Edges


```scala
  case object titanFather  extends TEdge(god,     TitanFather,  titan)
  case object godFather    extends TEdge(demigod, GodFather,    god)
  case object humanMother  extends TEdge(demigod, HumanMother,  human)
  case object brother      extends TEdge(god,     Brother,      god)
  case object pet          extends TEdge(god,     Pet,          monster)
  case object battled      extends TEdge(demigod, Battled,      monster)
  case object godLives     extends TEdge(god,     GodLives,     location)
  case object monsterLives extends TEdge(monster, MonsterLives, location)

}

```


------

### Index

+ src
  + main
    + scala
      + ohnosequences
        + scarph
          + [Denotation.scala][main/scala/ohnosequences/scarph/Denotation.scala]
          + [Edge.scala][main/scala/ohnosequences/scarph/Edge.scala]
          + [EdgeType.scala][main/scala/ohnosequences/scarph/EdgeType.scala]
          + [Expressions.scala][main/scala/ohnosequences/scarph/Expressions.scala]
          + [HasProperties.scala][main/scala/ohnosequences/scarph/HasProperties.scala]
          + [Property.scala][main/scala/ohnosequences/scarph/Property.scala]
          + [Vertex.scala][main/scala/ohnosequences/scarph/Vertex.scala]
          + [VertexType.scala][main/scala/ohnosequences/scarph/VertexType.scala]
  + test
    + scala
      + ohnosequences
        + scarph
          + [edges.scala][test/scala/ohnosequences/scarph/edges.scala]
          + [edgeTypes.scala][test/scala/ohnosequences/scarph/edgeTypes.scala]
          + [expressions.scala][test/scala/ohnosequences/scarph/expressions.scala]
          + [properties.scala][test/scala/ohnosequences/scarph/properties.scala]
          + titan
            + [godsImplementation.scala][test/scala/ohnosequences/scarph/titan/godsImplementation.scala]
            + [godsSchema.scala][test/scala/ohnosequences/scarph/titan/godsSchema.scala]
            + [TEdge.scala][test/scala/ohnosequences/scarph/titan/TEdge.scala]
            + [TitanGodsTest.scala][test/scala/ohnosequences/scarph/titan/TitanGodsTest.scala]
            + [TitanGraphSchema.scala][test/scala/ohnosequences/scarph/titan/TitanGraphSchema.scala]
            + [TitanSchemaTest.scala][test/scala/ohnosequences/scarph/titan/TitanSchemaTest.scala]
            + [TVertex.scala][test/scala/ohnosequences/scarph/titan/TVertex.scala]
          + [vertexTypes.scala][test/scala/ohnosequences/scarph/vertexTypes.scala]
          + [vertices.scala][test/scala/ohnosequences/scarph/vertices.scala]

[main/scala/ohnosequences/scarph/Denotation.scala]: ../../../../../main/scala/ohnosequences/scarph/Denotation.scala.md
[main/scala/ohnosequences/scarph/Edge.scala]: ../../../../../main/scala/ohnosequences/scarph/Edge.scala.md
[main/scala/ohnosequences/scarph/EdgeType.scala]: ../../../../../main/scala/ohnosequences/scarph/EdgeType.scala.md
[main/scala/ohnosequences/scarph/Expressions.scala]: ../../../../../main/scala/ohnosequences/scarph/Expressions.scala.md
[main/scala/ohnosequences/scarph/HasProperties.scala]: ../../../../../main/scala/ohnosequences/scarph/HasProperties.scala.md
[main/scala/ohnosequences/scarph/Property.scala]: ../../../../../main/scala/ohnosequences/scarph/Property.scala.md
[main/scala/ohnosequences/scarph/Vertex.scala]: ../../../../../main/scala/ohnosequences/scarph/Vertex.scala.md
[main/scala/ohnosequences/scarph/VertexType.scala]: ../../../../../main/scala/ohnosequences/scarph/VertexType.scala.md
[test/scala/ohnosequences/scarph/edges.scala]: ../edges.scala.md
[test/scala/ohnosequences/scarph/edgeTypes.scala]: ../edgeTypes.scala.md
[test/scala/ohnosequences/scarph/expressions.scala]: ../expressions.scala.md
[test/scala/ohnosequences/scarph/properties.scala]: ../properties.scala.md
[test/scala/ohnosequences/scarph/titan/godsImplementation.scala]: godsImplementation.scala.md
[test/scala/ohnosequences/scarph/titan/godsSchema.scala]: godsSchema.scala.md
[test/scala/ohnosequences/scarph/titan/TEdge.scala]: TEdge.scala.md
[test/scala/ohnosequences/scarph/titan/TitanGodsTest.scala]: TitanGodsTest.scala.md
[test/scala/ohnosequences/scarph/titan/TitanGraphSchema.scala]: TitanGraphSchema.scala.md
[test/scala/ohnosequences/scarph/titan/TitanSchemaTest.scala]: TitanSchemaTest.scala.md
[test/scala/ohnosequences/scarph/titan/TVertex.scala]: TVertex.scala.md
[test/scala/ohnosequences/scarph/vertexTypes.scala]: ../vertexTypes.scala.md
[test/scala/ohnosequences/scarph/vertices.scala]: ../vertices.scala.md