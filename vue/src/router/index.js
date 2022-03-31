import VueRouter from "vue-router";
import Login from "@/components/Login";
import CreateUser from "@/components/CreateUser";
import MainPage from "@/components/MainPage";
import UserInfo from "@/components/UserInfo";
import ArticleContent from "@/components/ArticleContent";
import DeliverArticle from "@/components/DeliverArticle";
export default new VueRouter({
    routes:[
        {
            path:"/login",
            component:Login,
        },
        {
            path:'/createUserInfo',
            component:CreateUser,
        },
        {
            path:"/",
            redirect:'/login'
        },
        {
            path:'/main',
            component:MainPage,
            redirect:'/main/articleList',
            children:[
                {
                    path:'userInfo',
                    component:UserInfo
                },
                {
                    path:'articleList',
                    component:ArticleContent
                },
                {
                    path:'deliverArticle',
                    component:DeliverArticle
                }
            ],
        }
    ]
})