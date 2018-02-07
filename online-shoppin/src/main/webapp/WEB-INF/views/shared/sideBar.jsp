<p class="lead"> Shop Name</p>

        <div class="container">
	
          <h1 class="my-4">Shop Name</h1>
          
          <c:forEach items="${categories}" var="category">
          <a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name}</a> 
          </c:forEach>
          
     

        </div>
