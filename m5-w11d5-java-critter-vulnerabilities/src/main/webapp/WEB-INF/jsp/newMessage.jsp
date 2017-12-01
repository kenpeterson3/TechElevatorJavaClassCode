<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<script type="text/javascript">
	var $messageTo;
	
	$(document).ready(function () {
		
		$messageTo = $("#messageTo").parent().detach();
		
		$("#visibility").change(function(event) {
			if($(this).val() == "private") {
				$(this).parent().after($messageTo);
			} else {
				$messageTo = $("#messageTo").parent().detach();
			}
		});	
	});
</script>

<h2>New Message</h2>

<c:url var="formAction" value="/users/${currentUser}/messages" />

<div class="row">
	<div class="col-md-5">
		<form action="${formAction}" method="POST">
			<div class="form-group">
				<select id="visibility" name="visibility" class="form-control">
					<option value="public">Public</option>
					<option value="private">Private</option>
				</select>
			</div>
			<div class="form-group">
				<label for="messageTo">To: </label>
				<input type="text" id="messageTo" name="messageTo" class="form-control" />	
			</div>
			<div class="form-group">
				<textarea id="messageText" name="messageText" class="form-control" rows="3" cols="50" placeholder="Your message goes here (140 character max)" maxlength="140"></textarea>	
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>

	<div class="col-md-9"></div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />