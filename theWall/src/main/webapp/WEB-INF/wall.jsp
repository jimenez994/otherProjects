<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="utf-8">
        <title>${user.name}</title>
    </head>
    <body>
        <h1>Welcome ${user.name}</h1>
        <div id="wrapper">
            <div id="welcome">
                <div id="welcomeleft">
                    <h1>The Wall</h1>
                    <h3>Messages</h3>
                </div>
                <div id="welcomeright">
                    <form action='/logout' method='POST'>
                        <input type="submit" name="logout" value="Logout" id="logout_button" class="btn btn-default navbar-btn">
                    </form>
                </div>
            </div>
            <div id="leftwrapper">
                <div class="bodytitle">
                    <h4>Messages:</h4>
                </div>
                <div class="bodyforms">
                    {% for message in messages: %}<h5 id="messagename">{{ message['name'] }} {{ message['username'] }}'s message says: </h5>
                    <p id="messagecontent">{{ message["message_text"] }}</p>
                    
                        {% endif %}
                        {% endfor %}
                            <ul>
                    </form>
                    <hr>
                        {% endfor %}
                </div>
            </div>
            <div id="rightwrapper">
                <div class="bodytitle">
                    <h4>Add a message:</h4>
                </div>
                <div class="bodyforms">
                    <form action='/makeMessage' name="add_message" method='POST'>
                        <textarea class="form-control" name="add_message"></textarea>
                        <input type="submit" name="add_message" value="Add message" class="btn btn-default navbar-btn">
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
