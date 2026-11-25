<AuthProvider>
<Routes>
<Route element={<LayoutLogin />}>
<Route path="/auth/register" element={<Register />}></Route>
<Route path="/auth/login" element={<Login />}></Route>
</Route>
<Route element={<ProtectedRoute>
<Layout />
</ProtectedRoute>}>
<Route path="/" element={<Home />} />
<Route path="/auth/logout" element={<Logout />}></Route>
</Route>
</Routes>
</AuthProvider>