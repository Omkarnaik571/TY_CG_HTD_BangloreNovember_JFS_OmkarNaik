import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PostsComponent } from './posts/posts.component';
import { AddPostsComponent } from './add-posts/add-posts.component';


const routes: Routes = [
  {path:'', component:HomeComponent},
  {path:'add-posts', component:AddPostsComponent},
  {path:'posts', component:PostsComponent},
  {path:'updatePosts', component:PostsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
