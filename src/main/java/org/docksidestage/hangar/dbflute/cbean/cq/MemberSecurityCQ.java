package org.docksidestage.hangar.dbflute.cbean.cq;

import org.dbflute.cbean.ConditionQuery;
import org.dbflute.cbean.sqlclause.SqlClause;
import org.docksidestage.hangar.dbflute.cbean.cq.bs.BsMemberSecurityCQ;

/**
 * The condition-query of MEMBER_SECURITY.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 */
public class MemberSecurityCQ extends BsMemberSecurityCQ {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor.
     * @param childQuery Child query as abstract class. (Nullable: If null, this is base instance.)
     * @param sqlClause SQL clause instance. (NotNull)
     * @param aliasName My alias name. (NotNull)
     * @param nestLevel Nest level.
     */
    public MemberSecurityCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(childQuery, sqlClause, aliasName, nestLevel);
    }
	
    // ===================================================================================
    //                                                                      Arrange Method
    //                                                                      ==============
	// You can make original arrange query methods here.
	// public void arrangeXxx() {
	//     ...
	// }
}
