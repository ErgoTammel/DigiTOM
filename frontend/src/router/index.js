import Vue from 'vue'
import VueRouter from 'vue-router'
import LogInView from "@/views/LogInView";
import MainView from "@/views/MainView";
import NewInspectionView from "@/views/NewInspectionView";
import NewConstructionSiteView from "@/views/NewConstructionSiteView";
import NewReportView from "@/views/NewReportView";
import ReportOverviewView from "@/views/ReportOverviewView";
import InspectorAllTasksView from "@/views/InspectorAllTasksView";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'logInRoute',
        component: LogInView
    },
    {
        path: '/main',
        name: 'mainRoute',
        component: MainView
    },
    {
        path: '/inspection/sites',
        name: 'newInspectionRoute',
        component: NewInspectionView
    },
    {
        path: '/construction-site/new',
        name: 'newConstructionSiteRoute',
        component: NewConstructionSiteView
    },
    {
        path: '/report/new',
        name: 'newReportViewRoute',
        component: NewReportView
    },
    {
        path: '/report/overview',
        name: 'ReportOverviewRoute',
        component: ReportOverviewView
    },
    {
        path: 'inspector/alltasks',
        name: 'InspectorAllTasksView',
        component: InspectorAllTasksView
    }
]

const router = new VueRouter({
    routes
})

export default router
