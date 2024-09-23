
  $(document).ready(function() {
      // Toggle the visibility of nested dropdowns
      $('.dropdown-submenu a.dropdown-toggle').on("click", function(e){
          var $el = $(this).next(".dropdown-menu");
          $('.dropdown-menu').not($el).hide(); // Hide other open submenus
          $el.toggle(); // Toggle the visibility of the current submenu
          e.stopPropagation();
          e.preventDefault();
      });

      // Handle subcategory selection and load data dynamically
      $('.dropdown-item').on('click', function(e) {
          var category = $(this).data('category');
          var subcategory = $(this).data('subcategory');

          // Show loading indicator (optional)
          $('#content').html('<p>Loading...</p>');

          // Fetch data dynamically
          $.ajax({
              url: '/auth/login', // Replace with your API endpoint
              method: 'GET',
              data: {
                  category: category,
                  subcategory: subcategory
              },
              success: function(response) {
                  // Update the content with the fetched data
                  $('#content').html(response);
              },
              error: function() {
                  $('#content').html('<p>An error occurred while loading the data.</p>');
              }
          });

          e.stopPropagation();
      });
  });
