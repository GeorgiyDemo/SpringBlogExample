$(document).ready(function () {


    $(document).ready(function () {
        const location = window.location.toString();

        //Если это страница с созданием блога
        if (location.includes("blogs/create.html")) {

            //Запрашиваем теги
            $.ajax({
                url: "http://localhost:8080/tags",
                type: "GET",
                dataType: "json",
                success: function (response) {
                    const element = document.getElementById("post-tags");

                    for (let i = 0; i < response.length; i++) {
                        let opt = document.createElement('option');
                        opt.value = response[i]["id"];
                        opt.innerHTML = response[i]["name"];
                        element.appendChild(opt);
                    }
                },
                error: function (error) {
                    console.log("Не удалось получить теги", error);
                }
            });

            //Запрашиваем авторов
            $.ajax({
                url: "http://localhost:8080/users",
                type: "GET",
                dataType: "json",
                success: function (response) {
                    const element = document.getElementById("post-author");
                    for (let i = 0; i < response.length; i++) {
                        let opt = document.createElement('option');
                        opt.value = response[i]["id"];
                        opt.innerHTML = response[i]["login"];
                        element.appendChild(opt);
                    }
                },
                error: function (error) {
                    console.log("Не удалось получить авторов", error);
                }
            });
        }

        //Страница со всеми постами
        else if (location.includes("blogs/all.html")) {

            //Запрашиваем посты
            $.ajax({
                url: "http://localhost:8080/posts",
                type: "GET",
                dataType: "json",
                success: function (response) {

                    const rootElement = document.getElementById("block-content");

                    for (let i = 0; i < response.length; i++) {
                        console.log(response[i])

                        let rootPost = document.createElement('div');
                        rootPost.className = "clean-blog-post"
                        let row = document.createElement("div")
                        row.className = "row"
                        let col = document.createElement("div")
                        col.className = "col-lg-7"

                        let header = document.createElement("h3")
                        header.innerHTML = response[i]["title"]
                        col.append(header)

                        let info = document.createElement("div")
                        info.className = "info";
                        let span = document.createElement("span")
                        span.className = "text-muted";
                        span.innerHTML = response[i]["dateTime"] + ", " + response[i]["authorPost"]["login"]
                        info.append(span)
                        col.append(info)

                        let p = document.createElement("p")
                        p.innerHTML = response[i]["text"]
                        col.append(p)

                        let form = document.createElement("form")
                        form.method = "get"
                        form.action = "./blog-post.html"

                        let input = document.createElement("input")
                        input.type = "hidden";
                        input.name = "id";
                        input.value = response[i]["id"]
                        form.append(input)

                        let button = document.createElement("button")
                        button.id = "post-click"
                        button.className = "btn btn-outline-primary btn-sm"
                        button.type = "submit"
                        button.innerHTML = "Подробнее"
                        form.append(button)
                        col.append(form)

                        row.append(col)
                        rootPost.append(row)
                        rootElement.appendChild(rootPost);
                    }
                },
                error: function (error) {
                    console.log("Не удалось получить теги", error);
                }
            });
        } else if (location.includes("blogs/blog-post.html")) {

            const queryString = window.location.search;
            const urlParams = new URLSearchParams(queryString);
            const id = urlParams.get('id');
            console.log(id);
            //Запрашиваем посты
            $.ajax({
                url: "http://localhost:8080/posts/" + id,
                type: "GET",
                dataType: "json",
                success: function (response) {
                    const rootElement = document.getElementById("post-body");

                    let header = document.createElement("h3")
                    header.innerHTML = response["title"]

                    let postInfo = document.createElement("div");
                    postInfo.className = "post-info";
                    let spanName = document.createElement("span");
                    spanName.innerHTML = response["authorPost"]["login"]
                    let spanDate = document.createElement("span");
                    spanDate.innerHTML = response["dateTime"];

                    let p = document.createElement("p");
                    p.innerHTML = response['text']


                    let form = document.createElement("form")
                    form.method = "get"
                    form.action = "./all.html"

                    let button = document.createElement("button")
                    button.id = "post-click"
                    button.className = "btn btn-outline-primary btn-sm"
                    button.type = "submit"
                    button.innerHTML = "Все посты"
                    form.append(button)


                    postInfo.append(spanName);
                    postInfo.append(spanDate);
                    rootElement.append(header);
                    rootElement.append(postInfo);
                    rootElement.append(p);
                    rootElement.append(form);

                },
                error: function (error) {
                    console.log("Не удалось получить теги", error);
                }
            });
        }
    });

    $("#tag-create-button").click(async function () {

        let postTitleElement = document.getElementById("post-title");
        let postAuthorElement = document.getElementById("post-author");
        let postTagsElement = document.getElementById("post-tags");
        let postTextElement = document.getElementById("post-text");

        let varData = {
            "authorPost": postAuthorElement.value,
            "text": postTextElement.value,
            "title": postTitleElement.value,
            "tags": [postTagsElement.value],
        };

        let response = await fetch("http://localhost:8080/posts", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify(varData)
        }, {mode: 'cors'}).then(function (response) {

            if (response.status === 401) {
                alert("Необходима авторизация")
            } else if (response.status === 201) {
                alert("Успешно добавили новый пост")
                postTitleElement.value = "";
                postAuthorElement.value = "";
                postTagsElement.value = "";
                postTextElement.value = "";
            } else {
                alert("Пролучили код " + response.status)
            }

        }).catch(function (error) {
            console.log("Не удалось создать пост", error);
        });
    });

});