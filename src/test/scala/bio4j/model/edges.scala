package bio4j.model.test

import bio4j.model._

object edges {

  import edgeTypes._
  import vertexTypes._
  import vertices._
  import properties._

  case class UMOImpl(
    val source: user.TaggedRep,
    val target: org.TaggedRep
  )(
    val isPublic: Boolean,
    val since: Int,
    val validUntil: Int
  )

  object memberOf extends Edge(MemberOf) { self =>
    type Rep = UMOImpl

    implicit object sourceGetter extends GetSource[user.type](user) {
      def apply(rep: self.TaggedRep) = rep.source
    }

    implicit object readSince extends GetProperty(since) {
      def apply(rep: self.TaggedRep) = rep.since
    }
    implicit object readValidUntil extends GetProperty(validUntil) {
      def apply(rep: self.TaggedRep) = rep.validUntil
    }
  }

}

class EdgeSuite extends org.scalatest.FunSuite {

  import edges._  
  import edgeTypes._

  import vertexTypes._
  import vertices._
  import properties._

  test("retrieve edge's sourde-edge-target") {

    import edges.memberOf._
    import edgeTypes.MemberOf._
    val u = user ->> UserImpl(id = "1ad3a34df", name = "Robustiano Satrústegui", since = 2349965)
    val o: org.TaggedRep = org ->> UserImpl(id = "NYSE:ORCL", name = "Orcale Inc.", since = 1977)

    val m = memberOf ->> UMOImpl(source = u, target = o)(isPublic = true, since = 2349965, validUntil = 38724987)

    assert((m source) === u)

    // I think this is a bug; this import shouldn't be needed
    import vertexTypes.User._
    assert(
      (m.source get id) === "1ad3a34df"
    )

    // val followers_ids = (user out follows) map { _ get id }

    /* Adding target getter externally: */
    implicit object targetGetter extends GetTarget[org.type](org) {
      def apply(rep: memberOf.TaggedRep) = rep.target
    }
    assert(m.target === o)

    /* Getting edge properties */
    assert(m.get(since) === 2349965)
    assert(m.get(validUntil) === 38724987)

    implicit val weForgotToImportIt = memberOf.tpe has isPublic
    implicit object readIsPublic extends GetProperty(isPublic) {
      def apply(rep: memberOf.TaggedRep) = rep.isPublic
    }
    assert(m.get(isPublic) === true)

    /* Just a static list of all `memberOf` edges */
    val members: List[memberOf.TaggedRep] = List(m,m,m)

    /* Retrieving edge */
    implicit object retrieveMemberOf extends user.RetrieveEdge(memberOf) {
      def apply(rep: user.TaggedRep) = members filter { _.source == rep }
    }
    assert(u.out(memberOf) === List(m,m,m))
  }
}
