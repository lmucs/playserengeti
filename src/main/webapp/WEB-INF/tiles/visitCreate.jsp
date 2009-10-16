<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

      <p>Check in UserId at LocationId</p>
      <p>
	      <form method="get" action="">
		      <div>
			      <div class="formLabel">
			          <label for="userId">userId: </label>
			      </div>
			      <div class="spaceInputBox">
			          <input type="text" name="userId"/>
			      </div>
		      </div>
			      <div>
			      <div class="formLabel">
			          <label for="locationId">locationId: </label>
			      </div>
			      <div class="spaceInputBox">
			          <input type="locationId" name="locationId"/>
			      </div>
		      </div>
		      <input type="submit" value="Check In!"/>
	      </form>
      </p>
