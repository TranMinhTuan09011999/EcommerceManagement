import { Product } from './../model/product';
import { Category } from './../model/category';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { ImageDetail } from '../model/image-detail';
import { User } from '../model/user';
import { OrderDetail } from '../order-detail';
import { Checkout } from '../checkout';

const API_URL = 'http://localhost:8080/api/user/';
const API_URL_ = 'http://localhost:8080/api/order/';
const API_URL_ADMIN = 'http://localhost:8080/api/admin/';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { }

  /*getPublicContent(): Observable<any> {
    return this.http.get(API_URL + 'all', { responseType: 'text' });
  }

  getUserBoard(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }

  getModeratorBoard(): Observable<any> {
    return this.http.get(API_URL + 'mod', { responseType: 'text' });
  }

  getAdminBoard(): Observable<any> {
    return this.http.get(API_URL + 'admin', { responseType: 'text' });
  }*/

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(API_URL + 'products')
      .pipe(retry(3),
          catchError(this.handleError));
  }

  getCategory(): Observable<Category[]>{
    return this.http.get<Category[]>(API_URL + 'category')
                    .pipe(
                      retry(3),
                      catchError(this.handleError)
                    );
  }

  getCategoryByName(name: string): Observable<Category>{
    return this.http.get<Category>(API_URL + 'category/' + name)
                    .pipe(
                      retry(3),
                      catchError(this.handleError)
                    );
  }

  getCategoryById(id: number): Observable<Category>{
    return this.http.get<Category>(API_URL + 'category/id/' + id)
                    .pipe(
                      retry(3),
                      catchError(this.handleError)
                    );
  }


  getPromotionProduct(): Observable<Product[]>{
    return this.http.get<Product[]>(API_URL + 'promotion')
                    .pipe(
                      retry(3),
                      catchError(this.handleError)
                    );
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };

  getProductByCategory(name: String): Observable<Category>{
    return this.http.get<Category>(API_URL + 'category/' + name)
                    .pipe(
                      retry(3),
                      catchError(this.handleError)
                    );
  }

  getProductDetail(name: String): Observable<Product>{
    return this.http.get<Product>(API_URL + 'product/' + name)
                  .pipe(
                    retry(3),
                    catchError(this.handleError)
                  );
  }

  getProductById(id: number): Observable<Product>{
    return this.http.get<Product>(API_URL + 'product/' + id)
                  .pipe(
                    retry(3),
                    catchError(this.handleError)
                  );
  }

  getImageDetail(imageId: number): Observable<ImageDetail[]>{
    return this.http.get<ImageDetail[]>(API_URL + 'product/detail/' + imageId)
                  .pipe(
                    retry(3),
                    catchError(this.handleError)
                  );
  }

  createImageDetail(list: ImageDetail[]): Observable<any> {
    return this.http.post<any>(API_URL + 'product/detail', list)
          .pipe(
            catchError(this.handleError)
          );
  }

  getAllUsers(token: String): Observable<User[]> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get<User[]>(API_URL_ADMIN + 'get-all', { headers: headers})
                  .pipe(
                    retry(3),
                    catchError(this.handleError))
  }

  getTop5Users(token: String): Observable<User[]> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get<User[]>(API_URL_ADMIN + 'get-top-5', { headers: headers})
                  .pipe(
                    retry(3),
                    catchError(this.handleError))
  }

  getUserById(token: String, id: number): Observable<User> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get<User>(API_URL_ADMIN + id, { headers: headers})
                .pipe(
                  retry(3),
                  catchError(this.handleError))
  }

  deleteUser(token: String, id: number): Observable<any> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.delete(API_URL_ADMIN + id, { headers: headers})
                  .pipe(
                    catchError(this.handleError))
  }

  updateUser(token: String, id: number, user: User): Observable<User> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.put<User>(API_URL_ADMIN  + id, user, { headers: headers})
                  .pipe(
                    catchError(this.handleError)
                  )
  }

  createCategory(token: String, category: Category): Observable<Category> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.post<Category>(API_URL_ADMIN + 'add-category', category, { headers: headers})
                  .pipe(
                    catchError(this.handleError))
  }

  deleteCategory(token: String, id: number): Observable<any> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.delete(API_URL_ADMIN + 'category/' + id, { headers: headers})
                  .pipe(
                  catchError(this.handleError))
  }

  updateCategory(token: String, id: number, category: Category): Observable<any> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.put<any>(API_URL_ADMIN + 'category/' + id, category, { headers: headers})
                  .pipe(
                    catchError(this.handleError)
                  )
  }

  createProduct(token: String, product: Product): Observable<any> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.post<any>(API_URL_ADMIN + 'product', product, { headers: headers})
                  .pipe(
                    catchError(this.handleError)
                  )
  }

  deleteProduct(token: String, id: number): Observable<any> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.delete(API_URL_ADMIN + 'product/' + id, { headers: headers})
                  .pipe(
                    catchError(this.handleError)
                  )
  }

  updateProduct(token: String, id: number, product: Product): Observable<any> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.put(API_URL_ADMIN + 'product/' + id, product, { headers: headers})
              .pipe(
                catchError(this.handleError)
              )
  }

  updateProductDetails(token: String, id: number, list: ImageDetail[]): Observable<any> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.put(API_URL + 'product/detail/' + id, list, { headers: headers})
              .pipe(
                catchError(this.handleError)
              )
  }

  getAllOrders(token: String): Observable<Checkout[]> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get<Checkout[]>(API_URL_ + 'listOrders',{ headers: headers})
                .pipe(
                  retry(3),
                  catchError(this.handleError)
                );
  }

  getTop10Orders(token: String): Observable<Checkout[]> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get<Checkout[]>(API_URL_ + 'get-top-10',{ headers: headers})
                .pipe(
                  retry(3),
                  catchError(this.handleError)
                );
  }

  getOrderDetails(token: String,id: number): Observable<OrderDetail[]>{
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get<OrderDetail[]>(API_URL_ + 'listOrderDetails/' + id, { headers: headers})
                  .pipe(
                    retry(3),
                    catchError(this.handleError)
                  );
  }

  cancel(token: String, id: number, status: number):Observable<Checkout>{
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.put<Checkout>(API_URL_ + 'listOrder/cancel/' + id,{status},{headers: headers})
                    .pipe(
                      catchError(this.handleError)
                    );
  }

  doesEmailExist(email: string): Observable<boolean> {
    let url = `${API_URL}emailcheck`;

    let content: any = {};
    content.email = email;

    let response$: Observable<boolean> = this.http.post<boolean>(url, content);

    return response$;
  }

  updateQuantityProduct(id: number, quantity: number): Observable<Product>{
    return this.http.put<Product>(API_URL + 'product/updateQuantity/' + id, {quantity})
              .pipe(
                catchError(this.handleError)
              )
  }

  getStatistics(token: String): Observable<number[]> {
    let tokenStr = 'Bearer ' + token;
    const headers = new HttpHeaders().set('Authorization', tokenStr);
    return this.http.get<number[]>(API_URL_ADMIN + 'get-statistics')
              .pipe(
                retry(3),
                catchError(this.handleError)
              );
  }
}
