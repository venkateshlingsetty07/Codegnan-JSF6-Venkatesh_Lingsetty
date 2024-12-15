<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
    /* Custom Header Styling */
    header {
        background-color: #3cb371; /* Solid green background */
        color: white; /* White text for contrast */
        display: flex;
        justify-content: space-between; /* Ensures the elements are spaced out */
        align-items: center;
        padding: 15px 20px; /* Spacing for a clean layout */
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); /* Subtle shadow effect */
    }

    /* Logo and Title Styling */
    header h1 {
        font-size: 1.8rem; /* Slightly larger font for the title */
        margin: 0;
        font-weight: bold;
    }

    /* Navigation Section */
    .nav-links {
        display: flex;
        align-items: center;
    }

    .order-history-btn {
        background-color: #343a40; /* Bootstrap dark color */
        color: white;
        text-decoration: none;
        padding: 8px 15px;
        border-radius: 5px;
        font-size: 0.9rem;
        font-weight: bold;
        margin-right: 20px;
        transition: background-color 0.3s ease;
    }

    .order-history-btn:hover {
        background-color: #23272b; /* Slightly darker on hover */
    }

    /* User Info and Logout Button */
    .user-info {
        display: flex;
        align-items: center;
    }

    .user-info p {
        margin: 0;
        margin-right: 15px;
        font-size: 1rem;
    }

    .logout-btn {
        background-color: #dc3545; /* Bootstrap red color */
        border: none;
        padding: 5px 10px;
        color: white;
        font-size: 0.9rem;
        cursor: pointer;
        text-decoration: none;
        border-radius: 3px;
    }

    .logout-btn:hover {
        background-color: #c82333; /* Slightly darker red on hover */
    }
</style>

<header>
    <!-- Left Corner: CGEcom Logo/Title -->
    <h1>CGEcom</h1>

    <!-- Right Corner: Navigation Links and User Info -->
    <div class="nav-links">
        <!-- Display 'Order History' button only for users with role USER -->
        <c:if test="${loggedInUser != null && loggedInUser.role == 'USER'}">
            <a href="/orders" class="order-history-btn">Order History</a>
        </c:if>

        <!-- User Info -->
        <div class="user-info">
            <c:if test="${loggedInUser != null}">
                <p>Welcome, ${loggedInUser.username}!</p>
                <a href="/logout" class="logout-btn">Sign Out</a>
            </c:if>
        </div>
    </div>
</header>
