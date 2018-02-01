/*
 * task_execution.proto
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: version not set
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package nextflow.ga4gh.tes.client.api;

import nextflow.ga4gh.tes.client.ApiCallback;
import nextflow.ga4gh.tes.client.ApiClient;
import nextflow.ga4gh.tes.client.ApiException;
import nextflow.ga4gh.tes.client.ApiResponse;
import nextflow.ga4gh.tes.client.Configuration;
import nextflow.ga4gh.tes.client.Pair;
import nextflow.ga4gh.tes.client.ProgressRequestBody;
import nextflow.ga4gh.tes.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import nextflow.ga4gh.tes.client.model.TesCancelTaskResponse;
import nextflow.ga4gh.tes.client.model.TesCreateTaskResponse;
import nextflow.ga4gh.tes.client.model.TesListTasksResponse;
import nextflow.ga4gh.tes.client.model.TesServiceInfo;
import nextflow.ga4gh.tes.client.model.TesTask;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskServiceApi {
    private ApiClient apiClient;

    public TaskServiceApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TaskServiceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for cancelTask
     * @param id  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call cancelTaskCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/v1/tasks/{id}:cancel"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call cancelTaskValidateBeforeCall(String id, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling cancelTask(Async)");
        }
        
        
        com.squareup.okhttp.Call call = cancelTaskCall(id, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Cancel a task.
     * 
     * @param id  (required)
     * @return TesCancelTaskResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TesCancelTaskResponse cancelTask(String id) throws ApiException {
        ApiResponse<TesCancelTaskResponse> resp = cancelTaskWithHttpInfo(id);
        return resp.getData();
    }

    /**
     * Cancel a task.
     * 
     * @param id  (required)
     * @return ApiResponse&lt;TesCancelTaskResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TesCancelTaskResponse> cancelTaskWithHttpInfo(String id) throws ApiException {
        com.squareup.okhttp.Call call = cancelTaskValidateBeforeCall(id, null, null);
        Type localVarReturnType = new TypeToken<TesCancelTaskResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Cancel a task. (asynchronously)
     * 
     * @param id  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call cancelTaskAsync(String id, final ApiCallback<TesCancelTaskResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = cancelTaskValidateBeforeCall(id, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TesCancelTaskResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for createTask
     * @param body  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createTaskCall(TesTask body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/v1/tasks";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createTaskValidateBeforeCall(TesTask body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling createTask(Async)");
        }
        
        
        com.squareup.okhttp.Call call = createTaskCall(body, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create a new task.
     * 
     * @param body  (required)
     * @return TesCreateTaskResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TesCreateTaskResponse createTask(TesTask body) throws ApiException {
        ApiResponse<TesCreateTaskResponse> resp = createTaskWithHttpInfo(body);
        return resp.getData();
    }

    /**
     * Create a new task.
     * 
     * @param body  (required)
     * @return ApiResponse&lt;TesCreateTaskResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TesCreateTaskResponse> createTaskWithHttpInfo(TesTask body) throws ApiException {
        com.squareup.okhttp.Call call = createTaskValidateBeforeCall(body, null, null);
        Type localVarReturnType = new TypeToken<TesCreateTaskResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new task. (asynchronously)
     * 
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createTaskAsync(TesTask body, final ApiCallback<TesCreateTaskResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createTaskValidateBeforeCall(body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TesCreateTaskResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getServiceInfo
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getServiceInfoCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/v1/tasks/service-info";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getServiceInfoValidateBeforeCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = getServiceInfoCall(progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * GetServiceInfo provides information about the service, such as storage details, resource availability, and  other documentation.
     * 
     * @return TesServiceInfo
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TesServiceInfo getServiceInfo() throws ApiException {
        ApiResponse<TesServiceInfo> resp = getServiceInfoWithHttpInfo();
        return resp.getData();
    }

    /**
     * GetServiceInfo provides information about the service, such as storage details, resource availability, and  other documentation.
     * 
     * @return ApiResponse&lt;TesServiceInfo&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TesServiceInfo> getServiceInfoWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = getServiceInfoValidateBeforeCall(null, null);
        Type localVarReturnType = new TypeToken<TesServiceInfo>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * GetServiceInfo provides information about the service, such as storage details, resource availability, and  other documentation. (asynchronously)
     * 
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getServiceInfoAsync(final ApiCallback<TesServiceInfo> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getServiceInfoValidateBeforeCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TesServiceInfo>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getTask
     * @param id  (required)
     * @param view OPTIONAL. Affects the fields included in the returned Task messages. See TaskView below.   - MINIMAL: Task message will include ONLY the fields:   Task.Id   Task.State  - BASIC: Task message will include all fields EXCEPT:   Task.ExecutorLog.stdout   Task.ExecutorLog.stderr   Input.content   TaskLog.system_logs  - FULL: Task message includes all fields. (optional, default to MINIMAL)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getTaskCall(String id, String view, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/v1/tasks/{id}"
            .replaceAll("\\{" + "id" + "\\}", apiClient.escapeString(id.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (view != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "view", view));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getTaskValidateBeforeCall(String id, String view, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'id' is set
        if (id == null) {
            throw new ApiException("Missing the required parameter 'id' when calling getTask(Async)");
        }
        
        
        com.squareup.okhttp.Call call = getTaskCall(id, view, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a task. TaskView is requested as such: \&quot;v1/tasks/{id}?view&#x3D;FULL\&quot;
     * 
     * @param id  (required)
     * @param view OPTIONAL. Affects the fields included in the returned Task messages. See TaskView below.   - MINIMAL: Task message will include ONLY the fields:   Task.Id   Task.State  - BASIC: Task message will include all fields EXCEPT:   Task.ExecutorLog.stdout   Task.ExecutorLog.stderr   Input.content   TaskLog.system_logs  - FULL: Task message includes all fields. (optional, default to MINIMAL)
     * @return TesTask
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TesTask getTask(String id, String view) throws ApiException {
        ApiResponse<TesTask> resp = getTaskWithHttpInfo(id, view);
        return resp.getData();
    }

    /**
     * Get a task. TaskView is requested as such: \&quot;v1/tasks/{id}?view&#x3D;FULL\&quot;
     * 
     * @param id  (required)
     * @param view OPTIONAL. Affects the fields included in the returned Task messages. See TaskView below.   - MINIMAL: Task message will include ONLY the fields:   Task.Id   Task.State  - BASIC: Task message will include all fields EXCEPT:   Task.ExecutorLog.stdout   Task.ExecutorLog.stderr   Input.content   TaskLog.system_logs  - FULL: Task message includes all fields. (optional, default to MINIMAL)
     * @return ApiResponse&lt;TesTask&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TesTask> getTaskWithHttpInfo(String id, String view) throws ApiException {
        com.squareup.okhttp.Call call = getTaskValidateBeforeCall(id, view, null, null);
        Type localVarReturnType = new TypeToken<TesTask>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a task. TaskView is requested as such: \&quot;v1/tasks/{id}?view&#x3D;FULL\&quot; (asynchronously)
     * 
     * @param id  (required)
     * @param view OPTIONAL. Affects the fields included in the returned Task messages. See TaskView below.   - MINIMAL: Task message will include ONLY the fields:   Task.Id   Task.State  - BASIC: Task message will include all fields EXCEPT:   Task.ExecutorLog.stdout   Task.ExecutorLog.stderr   Input.content   TaskLog.system_logs  - FULL: Task message includes all fields. (optional, default to MINIMAL)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTaskAsync(String id, String view, final ApiCallback<TesTask> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTaskValidateBeforeCall(id, view, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TesTask>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for listTasks
     * @param namePrefix OPTIONAL. Filter the list to include tasks where the name matches this prefix. If unspecified, no task name filtering is done. (optional)
     * @param pageSize OPTIONAL. Number of tasks to return in one page. Must be less than 2048. Defaults to 256. (optional)
     * @param pageToken OPTIONAL. Page token is used to retrieve the next page of results. If unspecified, returns the first page of results. See ListTasksResponse.next_page_token (optional)
     * @param view OPTIONAL. Affects the fields included in the returned Task messages. See TaskView below.   - MINIMAL: Task message will include ONLY the fields:   Task.Id   Task.State  - BASIC: Task message will include all fields EXCEPT:   Task.ExecutorLog.stdout   Task.ExecutorLog.stderr   Input.content   TaskLog.system_logs  - FULL: Task message includes all fields. (optional, default to MINIMAL)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call listTasksCall(String namePrefix, Long pageSize, String pageToken, String view, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/v1/tasks";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (namePrefix != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "name_prefix", namePrefix));
        if (pageSize != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page_size", pageSize));
        if (pageToken != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "page_token", pageToken));
        if (view != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "view", view));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call listTasksValidateBeforeCall(String namePrefix, Long pageSize, String pageToken, String view, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        
        com.squareup.okhttp.Call call = listTasksCall(namePrefix, pageSize, pageToken, view, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * List tasks. TaskView is requested as such: \&quot;v1/tasks?view&#x3D;BASIC\&quot;
     * 
     * @param namePrefix OPTIONAL. Filter the list to include tasks where the name matches this prefix. If unspecified, no task name filtering is done. (optional)
     * @param pageSize OPTIONAL. Number of tasks to return in one page. Must be less than 2048. Defaults to 256. (optional)
     * @param pageToken OPTIONAL. Page token is used to retrieve the next page of results. If unspecified, returns the first page of results. See ListTasksResponse.next_page_token (optional)
     * @param view OPTIONAL. Affects the fields included in the returned Task messages. See TaskView below.   - MINIMAL: Task message will include ONLY the fields:   Task.Id   Task.State  - BASIC: Task message will include all fields EXCEPT:   Task.ExecutorLog.stdout   Task.ExecutorLog.stderr   Input.content   TaskLog.system_logs  - FULL: Task message includes all fields. (optional, default to MINIMAL)
     * @return TesListTasksResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public TesListTasksResponse listTasks(String namePrefix, Long pageSize, String pageToken, String view) throws ApiException {
        ApiResponse<TesListTasksResponse> resp = listTasksWithHttpInfo(namePrefix, pageSize, pageToken, view);
        return resp.getData();
    }

    /**
     * List tasks. TaskView is requested as such: \&quot;v1/tasks?view&#x3D;BASIC\&quot;
     * 
     * @param namePrefix OPTIONAL. Filter the list to include tasks where the name matches this prefix. If unspecified, no task name filtering is done. (optional)
     * @param pageSize OPTIONAL. Number of tasks to return in one page. Must be less than 2048. Defaults to 256. (optional)
     * @param pageToken OPTIONAL. Page token is used to retrieve the next page of results. If unspecified, returns the first page of results. See ListTasksResponse.next_page_token (optional)
     * @param view OPTIONAL. Affects the fields included in the returned Task messages. See TaskView below.   - MINIMAL: Task message will include ONLY the fields:   Task.Id   Task.State  - BASIC: Task message will include all fields EXCEPT:   Task.ExecutorLog.stdout   Task.ExecutorLog.stderr   Input.content   TaskLog.system_logs  - FULL: Task message includes all fields. (optional, default to MINIMAL)
     * @return ApiResponse&lt;TesListTasksResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<TesListTasksResponse> listTasksWithHttpInfo(String namePrefix, Long pageSize, String pageToken, String view) throws ApiException {
        com.squareup.okhttp.Call call = listTasksValidateBeforeCall(namePrefix, pageSize, pageToken, view, null, null);
        Type localVarReturnType = new TypeToken<TesListTasksResponse>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List tasks. TaskView is requested as such: \&quot;v1/tasks?view&#x3D;BASIC\&quot; (asynchronously)
     * 
     * @param namePrefix OPTIONAL. Filter the list to include tasks where the name matches this prefix. If unspecified, no task name filtering is done. (optional)
     * @param pageSize OPTIONAL. Number of tasks to return in one page. Must be less than 2048. Defaults to 256. (optional)
     * @param pageToken OPTIONAL. Page token is used to retrieve the next page of results. If unspecified, returns the first page of results. See ListTasksResponse.next_page_token (optional)
     * @param view OPTIONAL. Affects the fields included in the returned Task messages. See TaskView below.   - MINIMAL: Task message will include ONLY the fields:   Task.Id   Task.State  - BASIC: Task message will include all fields EXCEPT:   Task.ExecutorLog.stdout   Task.ExecutorLog.stderr   Input.content   TaskLog.system_logs  - FULL: Task message includes all fields. (optional, default to MINIMAL)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call listTasksAsync(String namePrefix, Long pageSize, String pageToken, String view, final ApiCallback<TesListTasksResponse> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = listTasksValidateBeforeCall(namePrefix, pageSize, pageToken, view, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<TesListTasksResponse>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
