package in.co.movie.ticket.ctl;

import javax.servlet.http.HttpServletRequest;

import in.co.movie.ticket.entity.BaseEntity;
import in.co.movie.ticket.entity.UserEntity;
import in.co.movie.ticket.util.DataUtility;
import in.co.movie.ticket.util.DataValidator;

public class BaseCtl {

	protected static final String OP_SAVE = "Save";
	protected static final String OP_NEW="New";
	protected static final String OP_DELETE="Delete";
	protected static final String OP_CANCEL="Cancel";
	protected static final String OP_ERROR="Error";
	protected static final String OP_NEXT="Next";
	protected static final String OP_PREVIOUS="Previous";
	protected static final String OP_LOGOUT="Logout";
	protected static final String OP_GO="Go";
	protected static final String OP_GET="Get";
	
	protected static final String OP_RESET="Reset";
	
	protected static final String OP_ADDCART="addCart";
	
	protected static final String OP_PAYMENT="Payment";
	protected static final String OP_CONFIRM_PAYMENT="Confirm Payment";
	
	
protected BaseEntity populateDTO(BaseEntity dto, HttpServletRequest request) {
		
		String createdBy = request.getParameter("createdBy");
		String modifiedBy = null;

		UserEntity userbean = (UserEntity) request.getSession().getAttribute("user");

		if (userbean == null) {
			// If record is created without login
			createdBy = "root";
			modifiedBy = "root";
		} else {

			modifiedBy = userbean.getLogin();

			// If record is created first time
			if ("null".equalsIgnoreCase(createdBy)|| DataValidator.isNull(createdBy)) {
				createdBy = modifiedBy;
			}

		}

		dto.setCreatedBy(createdBy);
		dto.setModifiedBy(modifiedBy);

		long cdt = DataUtility.getLong(request.getParameter("createdDatetime"));

		if (cdt > 0) {
			dto.setCreatedDateTime(DataUtility.getTimestamp(cdt));
		} else {
			dto.setCreatedDateTime(DataUtility.getCurrentTimestamp());
		}

		dto.setModifiedDateTime(DataUtility.getCurrentTimestamp());
		
		return dto;
	}
}
