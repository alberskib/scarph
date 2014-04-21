package bio4j.model.test

import com.thinkaurelius.titan.core.TitanVertex

import vertexTypes._
import properties._
import bio4j.model._
import shapeless.record.FieldType
import SmthHasProperty._

trait AnyTVertex extends AnyVertex {

  type Rep = TitanVertex

  /* Reading any property from a TitanVertex */
  import AnyProperty._
  implicit def readFromTitanVertex(vr: TaggedRep) = 
    new ReadFrom[TaggedRep](vr) {
      def apply[P <: AnyProperty](p: P): p.Rep = vr.getProperty[p.Rep](p.label)
    }

  /* Getting a property from any TitanVertex */
  import SmthHasProperty._
  implicit def unsafeGetProperty[P <: AnyProperty: PropertyOf[this.Tpe]#is](p: P) = 
    new GetProperty[P](p) {
      def apply(rep: TaggedRep): p.Rep = rep.getProperty[p.Rep](p.label)
    }

}

class TVertex[VT <: AnyVertexType](val tpe: VT) extends AnyTVertex { type Tpe = VT }


case object titanUser extends TVertex[User.type](User)

abstract class stupidTest {

  import vertexTypes._
  import User._
  import titanUser._
  import AnyProperty._

  val uh: titanUser.TaggedRep

  val z = uh get id
  val ohoh = uh %: id
  def getId(u: titanUser.TaggedRep) = u.get(id)
}
